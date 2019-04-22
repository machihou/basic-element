package cn.boommanpro.web.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.web.controller.form.ComplexForm;
import cn.boommanpro.web.validate.ValidateMobile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("base")
public class BaseController {

    @GetMapping("queryMobile")
    public CallResult queryMobile(@ValidateMobile String mobile){
        return CallResult.success(mobile);
    }

    @GetMapping("complexQuery")
    public CallResult complexQuery(@Valid ComplexForm complexForm){
        return CallResult.success(complexForm);
    }
}
