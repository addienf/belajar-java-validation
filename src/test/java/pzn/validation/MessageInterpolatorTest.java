package pzn.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Order;

import java.util.Locale;
import java.util.Set;

public class MessageInterpolatorTest extends AbstractValidatorTest{

    @Test
    void create() {
        MessageInterpolator messageInterpolator = validatorFactory.getMessageInterpolator();

        Order order = new Order();
        Set<ConstraintViolation<Order>> violations = validator.validate(order);

        for (var violation : violations){
            System.out.println(violation.getMessageTemplate());
            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            System.out.println(messageInterpolator.interpolate(
                    violation.getMessageTemplate(), context, Locale.of("in", "ID")
            ));
        }
    }
}
