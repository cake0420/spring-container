package com.cake7.spring.configuration;

import com.cake7.spring.configuration.config.ConfigB;
import com.cake7.spring.configuration.service.ServiceA;
import com.cake7.spring.configuration.service.ServiceB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest(classes = {ServiceA.class, ServiceB.class})
@ContextConfiguration(classes = {ConfigB.class}) // 필요한 Configuration 클래스만 지정
public class ConfigBComponentTest {

    @Autowired
    private ServiceB serviceB;

    @Autowired
    private ConfigB configB;

    @Autowired
    private ServiceA serviceA;

    @Test
    void componentConfigCreatesNewInstance() {

        ServiceA beanA   = serviceA;
        ServiceB beanB   = serviceB;

        // ConfigB.a(), b()를 직접 호출해 얻은 새 인스턴스
        ServiceA directA = configB.a();
        ServiceB directB = configB.b();

        assertNotSame(beanB, directB, "ServiceB should be a fresh instance");
        assertNotSame(beanA, directA, "ServiceA should be a fresh instance");

    }
}
