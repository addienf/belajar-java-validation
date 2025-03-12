package pzn.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Payment;

import java.util.Set;

public class ValidatorConstraintTest extends AbstractValidatorTest{
    ValidatorFactory validatorFactory;
    Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void create() {
        Payment payment = new Payment();
        payment.setCreditCard("Wrong");

        validate(payment);

    }
}
