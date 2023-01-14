package com.sop.chapter10.authservice.services;

import com.sop.chapter10.authservice.entities.*;
import com.sop.chapter10.authservice.entities.AuthRequest;
import com.sop.chapter10.authservice.entities.AuthResponse;
import com.sop.chapter10.authservice.entities.User;
import com.sop.chapter10.authservice.repo.AuthRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthService {
    private final JwtUtil jwt;

    @Autowired
    public AuthService(final JwtUtil jwt){
        this.jwt = jwt;
    }

    @Autowired
    private AuthRepository authRepository;

    public List<User> getAllData(){
        return authRepository.findAll();
    }
    public boolean register(User user){
        try {
            System.out.println(user);
            User userObj = authRepository.findUser(user.getEmail());
            if(userObj == null){
                user.setRole("admin");
                authRepository.insert(user);
                System.out.println("success");
                return true;
            }else {
                System.out.println("มีผู้ใช้อยู่");
                return false;
            }

        } catch (Exception e){
            System.out.println("error");
            return false;
        }
    }
    public  AuthResponse logIn(AuthRequest authRequest){
        try{
            User userObj = authRepository.findUser(authRequest.getEmail());

            if(userObj != null){
                System.out.println(userObj);
                System.out.println(authRequest);
                if(userObj.getPassword().equals(authRequest.getPassword())){
                    User user = User.builder()
                            ._id(userObj.get_id())
                            .email(userObj.getEmail())
                            .role(userObj.getRole())
                            .build();
                    String accessToken = jwt.generate(user, "ACCESS");
                    String refreshToken = jwt.generate(user, "REFRESH");
                    System.out.println("match");
                    return new AuthResponse(accessToken, refreshToken);
                }else {
                    System.out.println("not match");
                    System.out.println(authRequest.getPassword());
                    System.out.println(userObj.getPassword());

                    return null;
                }
            }else {
                System.out.println("Not found User");
                return null;

            }
        }catch (Exception e){
            System.out.println("error");
            return null;
        }
    }
 
}
