package cn.boommanpro.controller;


import cn.boommanpro.common.CallResult;
import cn.boommanpro.service.ServiceSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqimeng
 */
@RestController
@RequestMapping("serviceSample")
public class ServiceSampleController {

    @Autowired
    private ServiceSampleService serviceSampleService;

    @GetMapping("listAll")
    public CallResult listAll(){
        return CallResult.success(serviceSampleService.listAll());
    }


    @GetMapping("listAllByStatus")
    public CallResult listAllByStatus(String status){
        return CallResult.success(serviceSampleService.listAllByStatus(status));
    }

    @GetMapping("save")
    public CallResult save() {
        serviceSampleService.save();
        return CallResult.success();
    }




}
