package cn.boommanpro.dao;

import cn.boommanpro.model.RowResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * from: https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-jpa-test
 */
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@SpringBootTest

public class RowResourceMapperTest {


    @Autowired
    private RowResourceMapper rowResourceMapper;

    @Before
    public void beforeSet(){

    }


    @Test
    public void listAll() {
        rowResourceMapper.insert(new RowResource(1, 1000, "cn.boommanpro.basic.h2.model.RowResource", "rowResource", Boolean.TRUE, Boolean.TRUE));
        rowResourceMapper.insert(new RowResource(2, 1000, "cn.boommanpro.basic.h2.model.RowResource1", "rowResource", Boolean.TRUE, Boolean.TRUE));
        rowResourceMapper.insert(new RowResource(3, 1000, "cn.boommanpro.basic.h2.model.RowResource2", "rowResource", Boolean.TRUE, Boolean.TRUE));
        rowResourceMapper.insert(new RowResource(4, 1000, "cn.boommanpro.basic.h2.model.RowResource3", "rowResource", Boolean.TRUE, Boolean.TRUE));

        RowResource rowResource = rowResourceMapper.findByFullName("cn.boommanpro.basic.h2.model.RowResource");
        assertThat(rowResource.getId()).isEqualTo(1);
    }

}