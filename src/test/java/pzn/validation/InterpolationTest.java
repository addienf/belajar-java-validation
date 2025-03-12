package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.entity.Order;

public class InterpolationTest extends AbstractValidatorTest{

    @Test
    void test() {
        Order order = new Order();
        order.setAmount(10L);
        order.setId("12345");

        validate(order);
    }
}
