package com.example.monolithic.user.domain.dto;

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
public class UserRequestDTO {

    // 추후 spring validation 이용한 패턴검증
    private String email ; 
    private String password; 
    
    // factory method pattern (dto -> entity) : JPA 작업가능
    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(this.email)
                .password(this.password)
                .build() ;
    }

}
