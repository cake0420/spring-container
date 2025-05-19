package com.cake7.spring.manualregistration.repository;

public class MyRepository {

    public MyRepository() {
        System.out.println("MyRepository 생성자 호출됨!");
    }

    public String getRepository() {
        return "MyRepository created";
    }
}
