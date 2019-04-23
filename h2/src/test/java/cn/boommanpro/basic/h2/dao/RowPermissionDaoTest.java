package cn.boommanpro.basic.h2.dao;

import cn.boommanpro.basic.h2.model.RowResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class RowPermissionDaoTest {

    @Autowired
    private RowResourceDao rowResourceDao;

    @Test
    public void listAll(){
        rowResourceDao.save(new RowResource(1,1000,"cn.boommanpro.basic.h2.model.RowResource","rowResource",Boolean.TRUE,Boolean.TRUE));
        rowResourceDao.save(new RowResource(2,1000,"cn.boommanpro.basic.h2.model.RowResource1","rowResource",Boolean.TRUE,Boolean.TRUE));
        rowResourceDao.save(new RowResource(3,1000,"cn.boommanpro.basic.h2.model.RowResource2","rowResource",Boolean.TRUE,Boolean.TRUE));
        rowResourceDao.save(new RowResource(4,1000,"cn.boommanpro.basic.h2.model.RowResource3","rowResource",Boolean.TRUE,Boolean.TRUE));

        RowResource rowResource = rowResourceDao.findByFullName("cn.boommanpro.basic.h2.model.RowResource");
        assertThat(rowResource.getId()).isEqualTo(1);
    }

}