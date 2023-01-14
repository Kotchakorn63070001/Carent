package com.sop.chapter10.authservice.controller;

import com.sop.chapter10.authservice.entities.AuthRequest;
import com.sop.chapter10.authservice.entities.AuthResponse;
import com.sop.chapter10.authservice.entities.User;
import com.sop.chapter10.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService){
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user){
        return ResponseEntity.ok(authService.register(user));
    }

@PostMapping(value = "/login")
public ResponseEntity<?> logIn(@RequestBody AuthRequest authRequest) {
    AuthResponse res = authService.logIn(authRequest);
    return res != null ? ResponseEntity.ok(res) : new ResponseEntity<>("INVALID AUTHENTICATION", HttpStatus.UNAUTHORIZED);
}
    @GetMapping(value = "/test")
    public List<User> test(){
        return authService.getAllData();
    }


}
