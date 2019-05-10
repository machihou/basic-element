package cn.boommanpro.dao;

import cn.boommanpro.model.ServiceSampleTwo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceSampleTwoDao extends CrudRepository<ServiceSampleTwo, String> {
}
