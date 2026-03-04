package com.example.monolithic.order.domain.dto;

import com.example.monolithic.order.domain.entity.OrderEntity;
import com.example.monolithic.order.domain.entity.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Integer qty;
    private OrderStatus orderStatus;

    public static OrderResponseDTO fromEntity(OrderEntity entity) {
        return OrderResponseDTO.builder()
                .id(entity.getId())
                .qty(entity.getQty())
                .orderStatus(entity.getOrderStatus())
                .build();
    }
    
}
