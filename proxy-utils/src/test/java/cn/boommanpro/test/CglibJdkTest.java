package cn.boommanpro.test;

import cn.boommanpro.service.CglibService;
import cn.boommanpro.service.JdkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CglibJdkTest {
    @Autowired
    private CglibService cglibService;
    @Autowired
    private JdkService jdkService;

    @Test
    public void test(){
        cglibService.test();
        jdkService.test();
    }
}
