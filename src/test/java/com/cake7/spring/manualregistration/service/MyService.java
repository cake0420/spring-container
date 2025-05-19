package com.cake7.spring.manualregistration.service;

import com.cake7.spring.manualregistration.repository.MyRepository;

public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository myRepository) {
        this.repository = myRepository;
    }

    public void printData() {
        System.out.println(repository.getRepository());
    }
}
