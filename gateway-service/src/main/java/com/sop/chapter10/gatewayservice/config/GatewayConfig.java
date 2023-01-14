package com.sop.chapter10.gatewayservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return  builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth-service"))
                .route("car-service", r -> r.path("/cars/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://car-service"))
                .route("order-service", r -> r.path("/order/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://order-service"))
                .route("payment-service", r -> r.path("/payments/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://payment-service"))
                .build();
    }
}
