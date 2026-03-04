package com.example.monolithic.common.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    public String getMethodName() {
        return "alive" ;
    }
}
