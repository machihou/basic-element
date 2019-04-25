package cn.boommanpro.service;


import cn.boommanpro.dao.RowPermissionMapper;
import cn.boommanpro.model.RowPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cache.annotation.EnableCaching;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * from:https://howtodoinjava.com/spring-boot2/spring-boot-mockito-junit-example/
 */
@RunWith(MockitoJUnitRunner.class)
@EnableCaching
public class RowPermissionServiceTest {

    @InjectMocks
    RowPermissionService rowPermissionService;



    @Mock
    RowPermissionMapper rowPermissionMapper;

    @Test
    public void listAll() {
        RowPermission rowPermission = new RowPermission();
        rowPermission.setId(1);
        rowPermission.setResourceId(1);
        when(rowPermissionMapper.selectList(null)).thenReturn(new ArrayList<>());
        List<RowPermission> rowPermissions = rowPermissionService.listAll();
        assertEquals(rowPermissions, rowPermissions);
        verify(rowPermissionMapper, times(1)).selectList(null);
    }


}