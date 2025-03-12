package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.data.CreditCardPaymentGroup;
import pzn.validation.data.VirtualAccountPaymentGroup;
import pzn.validation.entity.Payment;

import java.util.Set;

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
