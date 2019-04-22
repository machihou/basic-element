package cn.boommanpro.web.controller.form;

import cn.boommanpro.web.controller.validate.Nest;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class NestForm {

    @NotBlank(groups = Nest.class,message = "用户名不能为空")
    private String userName;

    @Range(groups = Nest.class,min = 0,max = 1,message = "性别只能为 0 or 1")
    @NotNull(groups = Nest.class,message = "性别必填")
    private Integer sex;

    @Email(groups = Nest.class,message = "邮箱不正确")
    @NotBlank(groups = Nest.class,message = "邮箱不能为空")
    private String emial;

    @Valid
    @NotNull(groups = Nest.class,message = "ServiceSampleList不能为空")
    @Size(min = 1,groups = Nest.class,message = "ServiceSampleList不能为空")
    private List<ServiceSample> serviceSampleList;
}
