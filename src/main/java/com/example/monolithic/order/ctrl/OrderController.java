package com.example.monolithic.order.ctrl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monolithic.order.domain.dto.OrderRequestDto;
import com.example.monolithic.order.domain.dto.OrderResponseDTO;
import com.example.monolithic.order.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderRequestDto request) {
        System.out.println(">>>> order controller orderCreate");
        OrderResponseDTO response = orderService.orderCreate(request);
        System.out.println(">>>> order controller response : " + response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
