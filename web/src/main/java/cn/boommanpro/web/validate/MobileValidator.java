package cn.boommanpro.web.validate;



import cn.boommanpro.util.MobileUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<ValidateMobile,String> {


    private boolean required = false;

    @Override
    public void initialize(ValidateMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return MobileUtil.isMobile(value);
        }
        return true;

    }


}
