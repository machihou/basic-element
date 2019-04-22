package cn.boommanpro.web.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.web.controller.form.NestForm;
import cn.boommanpro.web.controller.validate.Nest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nestValid")
public class NestValidController {

    @GetMapping("query")
    public CallResult query(@Validated(Nest.class) @RequestBody NestForm nestForm){
        return CallResult.success(nestForm);
    }
}
