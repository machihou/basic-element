package cn.boommanpro.web.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.web.controller.form.ComplexForm;
import cn.boommanpro.web.controller.validate.Insert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("insert")
public class InsertController {

    @GetMapping("complexQuery")
    public CallResult complexQuery( @Validated(Insert.class) ComplexForm complexForm){
        return CallResult.success(complexForm);
    }

}
