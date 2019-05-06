package cn.boommanpro;

import cn.boommanpro.cache.config.redis.RedisCustomCacheProperties;
import cn.boommanpro.dao.ServiceSampleMapper;
import cn.boommanpro.model.ServiceSample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
@Profile("!test")
public class ApplicationStartTask implements CommandLineRunner {


    @Autowired
    private RedisCacheManager redisCacheManager;

    @Autowired
    private RedisCustomCacheProperties redisCustomCacheProperties;

    private String[] status= new String[]{
            "已发货", "未发货", "取消", "派送中"
    };

    @Override
    public void run(String... args) throws Exception {
        log.info("{}", redisCacheManager);
        batchInsert();
    }


    @Autowired
    private ServiceSampleMapper serviceSampleMapper;






    public void batchInsert() {
        ServiceSample serviceSample;
        for (int i = 0; i < 1000000; i++) {

            serviceSample = new ServiceSample();
            serviceSample.setStatus(status[new Random().nextInt(status.length)]);
            serviceSample.setDepartment(new Random().nextInt(status.length) + "");
            serviceSample.setCreator("user" + new Random().nextInt(status.length));
            serviceSample.setSupervisor("user" + new Random().nextInt(status.length));
            serviceSample.setDescription("table" + i);
            serviceSampleMapper.insert(serviceSample);
        }

    }
}
