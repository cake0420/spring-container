package com.cake7.spring.configuration.config;

import com.cake7.spring.configuration.service.ServiceA;
import com.cake7.spring.configuration.service.ServiceB;
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
