package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.entity.Order;

import java.util.Locale;

public class CustomConstraintTest extends AbstractValidatorTest{
    @Test
    void test() {

        Locale.setDefault(Locale.of("in", "ID"));
        Order order = new Order();
        order.setId("abcd");

        validate(order);
    }
}
