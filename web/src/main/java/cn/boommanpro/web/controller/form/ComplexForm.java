package cn.boommanpro.web.controller.form;

import cn.boommanpro.web.controller.validate.Insert;
import cn.boommanpro.web.controller.validate.Update;
import cn.boommanpro.web.validate.ValidateMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class ComplexForm {
    @NotBlank(groups = Insert.class,message = "insert操作用户名不能为空")
    @Length(groups = Insert.class,min = 5, max = 20, message = "insert插入操作用户名长度应在5-20字符之间")

    @NotBlank(groups = Update.class,message = "update操作用户名不能为空")
    @Length(groups = Update.class,min = 5, max = 20, message = "update插入操作用户名长度应在5-20字符之间")

    @NotBlank(message = "base操作用户名不能为空")
    @Length(min = 5, max = 20, message = "base操作用户名长度应在5-20字符之间")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 5, max = 20, message = "密吗长度应在5-20字符之间")
    private String password;

    @Max(value = 0, message = "性别只能为0 or 1")
    @Min(value = 0, message = "性别只能为0 or 1")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    @ValidateMobile
    private String mobile;

    @Email
    private String mail;
}
