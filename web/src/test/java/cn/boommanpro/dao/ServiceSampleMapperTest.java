package cn.boommanpro.dao;

import cn.boommanpro.model.ServiceSample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceSampleMapperTest {

    @Autowired
    private ServiceSampleMapper serviceSampleMapper;

    String[] status;

    @Before
    public void setUp() throws Exception {
        status = new String[]{
                "已发货","未发货","取消","派送中"
        };
    }

    @Test
    public void batchInsert(){
        ServiceSample serviceSample;
        for (int i = 0; i < 1000000; i++) {

            serviceSample = new ServiceSample();
            serviceSample.setStatus(status[new Random().nextInt(status.length)]);
            serviceSample.setDepartment(new Random().nextInt(status.length)+"");
            serviceSample.setCreator("user"+new Random().nextInt(status.length));
            serviceSample.setSupervisor("user"+new Random().nextInt(status.length));
            serviceSample.setDescription("table"+i);
            serviceSampleMapper.insert(serviceSample);
        }

    }
}