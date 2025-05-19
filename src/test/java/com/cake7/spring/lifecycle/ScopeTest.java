package com.cake7.spring.lifecycle;


import com.cake7.spring.lifecycle.beanType.PrototypeBean;
import com.cake7.spring.lifecycle.beanType.SingletonBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(classes = {SingletonBean.class, PrototypeBean.class})
public class ScopeTest {
    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("bean test")
    public void BeanTest() {
        System.out.println("singletonBean test");
        SingletonBean bean1 = (context.getBean(SingletonBean.class));
        SingletonBean bean2 = (context.getBean(SingletonBean.class));
        System.out.println("bean1==bean2");
        assertSame(bean1, bean2, "싱글톤 빈은 동일한 객체입니다");
        PrototypeBean bean3 = (context.getBean(PrototypeBean.class));
        PrototypeBean bean4 = (context.getBean(PrototypeBean.class));
        System.out.println("bean3!=bean4");
        assertNotSame(bean3, bean4, "프로토타입 빈은 서로 다른 객체입니다");
    }
}
