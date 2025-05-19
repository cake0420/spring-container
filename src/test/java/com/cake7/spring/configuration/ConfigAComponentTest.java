package com.cake7.spring.configuration;

import com.cake7.spring.configuration.config.ConfigA;
import com.cake7.spring.configuration.service.ServiceA;
import com.cake7.spring.configuration.service.ServiceB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
@ContextConfiguration(classes = {ConfigA.class}) // 필요한 Configuration 클래스만 지정
public class ConfigAComponentTest {

    @Autowired
    private ConfigA configA;
    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;

    @Test
    void configurationCreatesNewInstance() {
        ServiceA beanA   = serviceA;
        ServiceB beanB   = serviceB;

        ServiceA directA = configA.A();
        ServiceB directB = configA.B();

        assertSame(beanB, directB, "ServiceB should be a same instance");
        assertSame(beanA, directA, "ServiceA should be a same instance");
    }
}
