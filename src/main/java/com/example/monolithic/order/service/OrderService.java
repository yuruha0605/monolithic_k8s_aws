package com.example.monolithic.order.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monolithic.order.dao.OrderRepository;
import com.example.monolithic.order.domain.dto.OrderRequestDTO;
import com.example.monolithic.order.domain.dto.OrderResponseDTO;
import com.example.monolithic.order.domain.entity.OrderEntity;
import com.example.monolithic.product.dao.ProductRepository;
import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.dao.UserRepository;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository   orderRepository ;
    private final UserRepository    userRepository ;
    private final ProductRepository productRepository ;

    public OrderResponseDTO orderCreate(OrderRequestDTO request) { 
        System.out.println(">>>> order service orderCreate");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        System.out.println(">>>> auth getName : "+auth.getName()); 

        UserEntity user = userRepository.findById(auth.getName())
                            .orElseThrow(() -> 
                                new RuntimeException("User Not Found!!")) ; 

        ProductEntity product = productRepository.findById(request.getProductId())    
                                .orElseThrow(() -> 
                                    new RuntimeException("Product Not Found!!")) ;                         

        System.out.println(">>>> order service 재고관리!!!!!!!!"); 
        Integer qty = request.getQty() ;                             
        if(product.getStockQty() < qty) {
            throw new RuntimeException(">>>> 재고부족");
        }else {
            product.updateStockQty(request.getQty()); 
        }
        OrderEntity order = OrderEntity.builder()
                                .qty(qty)
                                .product(product)
                                .user(user)
                                .build() ; 

        return OrderResponseDTO.fromEntity(orderRepository.save(order)) ;

    }


}
