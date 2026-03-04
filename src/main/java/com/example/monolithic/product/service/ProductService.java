package com.example.monolithic.product.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monolithic.product.dao.ProductRepository;
import com.example.monolithic.product.domain.dto.ProductRequestDTO;
import com.example.monolithic.product.domain.dto.ProductResponseDTO;
import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.dao.UserRepository;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository; 
    private final UserRepository    userRepository ;


    public ProductResponseDTO productCreate(ProductRequestDTO request) {
        System.out.println(">>>> product service productCreate");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(">>>> auth getName : " + auth.getName());

        UserEntity user = userRepository.findById(auth.getName())
                                        .orElseThrow(() -> new RuntimeException("User not found"));

        ProductEntity product = request.toEntity(user);
        return ProductResponseDTO.fromEntity(productRepository.save(product));
    }
}
