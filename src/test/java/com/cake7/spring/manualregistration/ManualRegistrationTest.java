package com.cake7.spring.manualregistration;

import com.cake7.spring.manualregistration.repository.MyRepository;
import com.cake7.spring.manualregistration.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootTest(classes = {MyService.class, MyRepository.class})
public class ManualRegistrationTest {

    @Test
    public void manualRegistrationTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyRepository.class);
        context.registerBean(MyService.class, () -> new MyService(context.getBean(MyRepository.class)));
        context.refresh();
        MyService service = context.getBean(MyService.class);
        service.printData();
    }
}
