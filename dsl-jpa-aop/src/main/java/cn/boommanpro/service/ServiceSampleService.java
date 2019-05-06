package cn.boommanpro.service;


import cn.boommanpro.dao.ServiceSampleDao;
import cn.boommanpro.dao.ServiceSamplePredicate;
import cn.boommanpro.model.QServiceSample;
import cn.boommanpro.model.ServiceSample;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqimeng
 */
@Service
public class ServiceSampleService {
    private final ServiceSamplePredicate serviceSamplePredicate;

    private final ServiceSampleDao serviceSampleDao;

    public ServiceSampleService(ServiceSamplePredicate serviceSamplePredicate, ServiceSampleDao serviceSampleDao) {
        this.serviceSamplePredicate = serviceSamplePredicate;
        this.serviceSampleDao = serviceSampleDao;
    }


    public List<ServiceSample> listAll(){
        Iterable<ServiceSample> all = serviceSamplePredicate.findAll();
        List<ServiceSample> serviceSampleList = new ArrayList<>();
        all.forEach(serviceSample -> serviceSampleList.add(serviceSample));
        return serviceSampleList;
    }


    public List<ServiceSample> listAllByStatus(String status){
        Iterable<ServiceSample> all = serviceSamplePredicate.findAll(QServiceSample.serviceSample.status.eq(status));
        List<ServiceSample> serviceSampleList = new ArrayList<>();
        all.forEach(serviceSample -> serviceSampleList.add(serviceSample));
        return serviceSampleList;
    }
    public void save(){
        ServiceSample serviceSample = new ServiceSample();
        serviceSample.setServiceId(1);
        serviceSample.setCreator("123");
        serviceSampleDao.save(serviceSample);
    }



}
