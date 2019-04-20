package cn.boommanpro.basic.h2.dao;

import cn.boommanpro.basic.h2.model.RowPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowPermissionDao extends CrudRepository<RowPermission,Integer> {
}
