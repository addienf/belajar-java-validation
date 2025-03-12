package pzn.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Person;

import java.util.Set;

public class ConstraintTest {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    Person person = new Person();

    @Test
    void create() {
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        for (var constraintViolation : constraintViolations){
            System.out.println(constraintViolation.getMessage());
        }

        validatorFactory.close();
    }
}
