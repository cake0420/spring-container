package com.cake7.spring.config;

import com.cake7.spring.service.ServiceA;
import com.cake7.spring.service.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean
    public ServiceA A() {
        return new ServiceA(B());
    }

    @Bean
    public ServiceB B() {
        return new ServiceB();
    }

}
