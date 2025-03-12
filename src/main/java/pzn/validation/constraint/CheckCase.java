package pzn.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pzn.validation.data.CaseMode;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {
    CaseMode mode();

    String message() default "Value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
