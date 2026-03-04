package com.example.monolithic.product.domain.entity;

import com.example.monolithic.common.domain.BaseTimeEntity;
import com.example.monolithic.user.domain.entity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MONOLITHIC_PRODUCT_TBL")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseTimeEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 

    private String  name ;
    private Integer price ; 
    private Integer stockQty ; 

    // user가 상품을 등록하는 것 때문에 관계 필요!!!
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") 
    private UserEntity user ; 

    
    public void updateStockQty(int stockQty) {
        this.stockQty = this.stockQty - stockQty ; 
    }
    

}

