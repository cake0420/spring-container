package com.cake7.spring.manualregistration;

import com.cake7.spring.manualregistration.repository.MyRepository;
import com.cake7.spring.manualregistration.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(classes = {MyService.class, MyRepository.class})
public class ManualRegistrationTest {

    @Test
    public void manualRegistrationTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyRepository.class);
        context.registerBean(MyService.class, () -> new MyService(context.getBean(MyRepository.class)));
        context.refresh();
        MyService service1 = context.getBean(MyService.class);
        MyService service2 = context.getBean(MyService.class);
        System.out.println(service1);
        System.out.println(service2);
        assertSame(service1, service2);
        service1.printData();
    }

    @Test
    public void manualRegistrationTestWithProtoType() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyRepository.class);
        context.registerBean(MyService.class, () ->
                new MyService(context.getBean(MyRepository.class)),
                beanDefinition -> beanDefinition.setScope("prototype"));
        context.refresh();
        MyService service1 = context.getBean(MyService.class);
        MyService service2 = context.getBean(MyService.class);

        System.out.println(service1);
        System.out.println(service2);

        assertNotSame(service1, service2);
    }
}
