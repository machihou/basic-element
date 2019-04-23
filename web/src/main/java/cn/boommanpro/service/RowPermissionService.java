package cn.boommanpro.service;

import cn.boommanpro.dao.RowPermissionMapper;
import cn.boommanpro.model.RowPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowPermissionService {
    @Autowired
    private RowPermissionMapper rowPermissionMapper;

    @Cacheable(cacheNames = "cacheNames")
    public List<RowPermission> listAll(){
        return rowPermissionMapper.selectList(null);
    }
}
