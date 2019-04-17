package cn.boommanpro.basic.h2.dao;

import cn.boommanpro.basic.h2.model.RowPermission;
import org.springframework.data.repository.CrudRepository;

public interface RowResourceDao extends CrudRepository<RowPermission,Integer> {
}
