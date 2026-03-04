package com.example.monolithic.product.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monolithic.product.domain.dto.ProductRequestDTO;
import com.example.monolithic.product.domain.dto.ProductResponseDTO;
import com.example.monolithic.product.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService ;

    @PostMapping("/create")
    public ResponseEntity<?> create(ProductRequestDTO request) {
        System.out.println(">>>> product ctrl path : /create"); 
        System.out.println(">>>> params : "+ request); 

        ProductResponseDTO response =  productService.productCreate(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response) ;

    }
    

}
