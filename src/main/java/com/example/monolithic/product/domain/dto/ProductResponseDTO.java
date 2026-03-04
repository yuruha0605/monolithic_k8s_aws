package com.example.monolithic.product.domain.dto;

import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.domain.dto.UserResponseDTO;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long    id ; 
    private String  name ; 
    private Integer price ; 
    private Integer stockQty ; 
    
    public static ProductResponseDTO fromEntity(ProductEntity entity) {
        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .stockQty(entity.getStockQty())
                .build();
    }
}
