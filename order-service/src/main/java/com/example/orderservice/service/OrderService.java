package com.example.orderservice.service;

import com.example.orderservice.pojo.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
            return orders;
        } catch (Exception e) {
            return null;
        }

    }

    @RabbitListener(queues = "AddOrder")
    public Boolean addOrder(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateStatus(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

