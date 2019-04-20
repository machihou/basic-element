package cn.boommanpro.basic.h2.dao;

import cn.boommanpro.basic.h2.model.RowResource;
import org.springframework.data.repository.CrudRepository;

public interface RowResourceDao extends CrudRepository<RowResource,Integer> {
    RowResource findByFullName(String fullName);
}
