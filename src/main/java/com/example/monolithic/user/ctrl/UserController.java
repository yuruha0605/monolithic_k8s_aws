package com.example.monolithic.user.ctrl;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monolithic.user.domain.dto.UserRequestDTO;
import com.example.monolithic.user.domain.dto.UserResponseDTO;
import com.example.monolithic.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    

    private final UserService userService ;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody UserRequestDTO request) {
        
        System.out.println(">>>> user ctrl path : /signIn"); 
        System.out.println(">>>> params : "+ request); 
        
        Map<String, Object> map = userService.signIn(request);
        
        System.out.println(">>>> response body : "+(UserResponseDTO)(map.get("response")));
        System.out.println(">>>> response at   : "+(String)(map.get("access")));
        System.out.println(">>>> response rt   : "+(String)(map.get("refresh")));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+(String)(map.get("access")) ) ;
        headers.add("Refresh-Token", (String)(map.get("refresh")) ) ;
        headers.add("Access-Control-Expose-Headers","Authorization, Refresh-Token");
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body( (String)(map.get("access")) ) ;     
    }

}
