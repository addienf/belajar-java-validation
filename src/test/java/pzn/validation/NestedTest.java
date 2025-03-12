package pzn.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Address;
import pzn.validation.entity.Person;

import java.util.Set;

public class NestedTest {

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    Person person = new Person();

    @Test
    void name() {
        person.setAddress(new Address());
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        for (var constraintViolation : constraintViolations){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getLeafBean());
            System.out.println(constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println(constraintViolation.getInvalidValue());
            constraintViolation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }
}
