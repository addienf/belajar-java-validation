package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.entity.Order;

import java.util.Locale;

public class I18NTest extends AbstractValidatorTest{
    @Test
    void create() {
        Locale.setDefault(new Locale("in", "ID"));

        Order order = new Order();
        order.setAmount(10L);
        order.setId("12345");

        validate(order);
    }
}
