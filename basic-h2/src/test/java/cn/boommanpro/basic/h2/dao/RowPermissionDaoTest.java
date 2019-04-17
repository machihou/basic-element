package cn.boommanpro.basic.h2.dao;

import cn.boommanpro.basic.h2.model.RowPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RowPermissionDaoTest {

    @Autowired
    private RowPermissionDao rowPermissionDao;

    @Test
    public void listAll(){
        Iterable<RowPermission> all = rowPermissionDao.findAll();

        System.out.println(all);
    }

}