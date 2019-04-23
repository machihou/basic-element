package cn.boommanpro.controller.form;

import cn.boommanpro.controller.validate.Nest;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ServiceSample {

    @Range(groups = Nest.class,min = 0,message = "业务id必须大于0")
    @NotNull(groups = Nest.class,message = "业务id不能为空")
    private Integer id;
}
