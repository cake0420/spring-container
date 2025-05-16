package com.cake7.spring.config;

import com.cake7.spring.service.ServiceA;
import com.cake7.spring.service.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigB {

    @Bean
    public ServiceA a() {
        return new ServiceA(b());
    }

    @Bean
    public ServiceB b() {
        return new ServiceB();
    }
}
