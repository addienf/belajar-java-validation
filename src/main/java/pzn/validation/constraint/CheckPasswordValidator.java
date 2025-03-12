package pzn.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pzn.validation.entity.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext context) {

        if (register.getPassword() == null || register.getReTypePassword() == null){
            return true;
        }

        boolean isValid = register.getPassword().equals(register.getReTypePassword());

        if (!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(messageTemplate)
                        .addPropertyNode("password")
                        .addConstraintViolation();
                context.buildConstraintViolationWithTemplate(messageTemplate)
                        .addPropertyNode("reTypePassword")
                        .addConstraintViolation();
        }
        return isValid;
    }
}
