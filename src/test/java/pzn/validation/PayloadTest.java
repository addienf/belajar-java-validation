package pzn.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Customer;
import pzn.validation.entity.Payment;
import pzn.validation.group.CreditCardPaymentGroup;
import pzn.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void test() {
        Customer customer = new Customer();
        customer.setEmail("test@ex.com");
        customer.setName("Fauzan");

        Payment payment = new Payment();
        payment.setOrderId("1232");
        payment.setCustomer(customer);
        payment.setAmount(20_000L);
        payment.setCreditCard("wrond");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (var violation : violations){
            System.out.println(" ");
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
            violation.getConstraintDescriptor().getPayload().forEach(aClass -> {
                if (aClass == EmailErrorPayload.class){
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            });

        }


    }
}
