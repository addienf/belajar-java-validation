package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.group.CreditCardPaymentGroup;
import pzn.validation.group.VirtualAccountPaymentGroup;
import pzn.validation.entity.Payment;

public class GroupConstraintTest extends AbstractValidatorTest{


    @Test
    void testCreatePayment() {
        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        validate(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testCreateVA() {
        Payment payment = new Payment();

        validate(payment, VirtualAccountPaymentGroup.class);
    }
}
