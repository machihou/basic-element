package cn.boommanpro.web.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// 约束注解应用的目标元素类型(TYPE   ,METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER等)
@Target({TYPE, METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
// 约束注解应用的时机
@Retention(RUNTIME)
@Documented
// 与约束注解关联的验证器
@Constraint(validatedBy = { MobileValidator.class})
public @interface ValidateMobile {

    //是否校验
    boolean required() default true;
    // 约束注解验证时的输出消息
    String message() default "手机号码格式不正确";
    // 约束注解在验证时所属的组别
    Class<?>[] groups() default { };
    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default { };

}
