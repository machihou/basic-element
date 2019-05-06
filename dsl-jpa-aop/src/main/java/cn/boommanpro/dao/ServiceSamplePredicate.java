package cn.boommanpro.dao;


import cn.boommanpro.model.ServiceSample;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wangqimeng
 */
@Repository
public interface ServiceSamplePredicate   extends org.springframework.data.repository.Repository<ServiceSample,Integer>, QuerydslPredicateExecutor<ServiceSample>
{



}
