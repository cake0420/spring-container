package com.cake7.spring.configuration.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    private final ServiceB serviceB;
    public ServiceA(ServiceB b) {
        this.serviceB = b;
        System.out.println("ServiceA created with " + b);
    }

    public ServiceB getServiceB() {
        return serviceB;
    }
}
