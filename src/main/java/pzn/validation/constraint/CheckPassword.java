package pzn.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {
    String message() default "Password must same with retype password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
