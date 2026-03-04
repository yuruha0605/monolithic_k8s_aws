package com.example.monolithic.product.domain.dto;

import com.example.monolithic.product.domain.entity.ProductEntity;
import com.example.monolithic.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    //field
    private String name;
    private Integer price;
    private Integer stockQty;

    public ProductEntity toEntity(UserEntity user) {
        return ProductEntity.builder()
                .name(this.name)
                .price(this.price)
                .stockQty(this.stockQty)
                .user(user)
                .build();
    }

    
}
