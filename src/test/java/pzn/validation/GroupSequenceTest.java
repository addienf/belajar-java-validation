package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.group.PaymentGroup;
import pzn.validation.entity.Payment;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void test() {
        Payment payment = new Payment();

        validate(payment, PaymentGroup.class);
    }
}
