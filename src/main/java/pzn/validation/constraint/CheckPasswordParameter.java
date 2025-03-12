package pzn.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();

    int reTypePasswordParam();

    String message() default "Password is not same with reTypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
