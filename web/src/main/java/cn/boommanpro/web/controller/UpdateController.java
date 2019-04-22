package cn.boommanpro.web.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.web.controller.form.ComplexForm;
import cn.boommanpro.web.controller.validate.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("update")
public class UpdateController {
    @GetMapping("complexQuery")
    public CallResult complexQuery(@Validated(Update.class) ComplexForm complexForm){
        return CallResult.success(complexForm);
    }
}
