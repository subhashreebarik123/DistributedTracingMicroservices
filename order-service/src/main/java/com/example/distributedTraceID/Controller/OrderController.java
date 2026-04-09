package com.example.distributedTraceID.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public String createOrder() {

        String response = restTemplate.getForObject(
                "http://localhost:8082/payment/pay",
                String.class);

        return "Order Created -> " + response;
    }
}
