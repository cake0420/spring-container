package com.cake7.spring.beanType;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    @PostConstruct
    public void init() {
        System.out.println("SingletonBean init"+this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SingletonBean destroy"+this);
    }
}
