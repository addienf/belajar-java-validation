package pzn.validation.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pzn.validation.data.CaseMode;

import java.lang.annotation.*;

@CheckCase(mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(message = "{order.id.notblank}")
@Size(min = 1, max = 10, message = "order.id.size")
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {
    String message() default "Value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
