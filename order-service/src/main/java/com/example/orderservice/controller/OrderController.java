package com.example.orderservice.controller;

import com.example.orderservice.pojo.Car;
import com.example.orderservice.pojo.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrder(){
        List<Order> orders = orderService.getAllOrders();
        return  ResponseEntity.ok(orders);
    }
    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestParam("carId") String carId
            ,
                                    @RequestParam("timeStart") String timeStart,
                                    @RequestParam("timeEnd") String timeEnd,
                                    @RequestParam("dateStart") String dateStart,
                                    @RequestParam("dateEnd") String dateEnd,
                                    @RequestParam("location") String location,
                                    @RequestParam("totalPrice") Integer totalPrice,
                                    @RequestParam("user_name") String user_name,
                                    @RequestParam("user_mail") String user_mail
                                    ){
        boolean status = orderService.addOrder(new Order(null,carId,timeStart,timeEnd,
                dateStart,dateEnd,location,totalPrice,"Pending",user_name, user_mail));
        rabbitTemplate.convertSendAndReceive("OrderDirectExchange","addOrder",carId);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/updateStatus/{_id}/{status_check}")
    public boolean updateStatus(@PathVariable("_id") String _id,@PathVariable("status_check") String status_check) throws IOException {
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            if (order.get_id().equals(_id)) {
                 orderService.addOrder(new Order(_id,order.getCarId(),order.getTimeStart(),order.getTimeEnd(),
                        order.getDateStart(),order.getDateEnd(),order.getLocation(),order.getTotalPrice(),
                         status_check,order.getUser_name(), order.getUser_mail()));
                return true;
            }
        }


        return true;
    }
}
