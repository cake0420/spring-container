package com.cake7.spring.lifecycle.beanType;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    @PostConstruct
    public void init() {
        System.out.println("PrototypeBean init"+this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PrototypeBean destroy"+this);
    }
}
