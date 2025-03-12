package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.group.CreditCardPaymentGroup;
import pzn.validation.entity.Customer;
import pzn.validation.entity.Payment;

public class GroupConvertTest extends AbstractValidatorTest{

    @Test
    void name() {
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validate(payment, CreditCardPaymentGroup.class);
    }
}
