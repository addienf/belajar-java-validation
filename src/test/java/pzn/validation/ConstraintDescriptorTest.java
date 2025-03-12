package pzn.validation;

import org.junit.jupiter.api.Test;
import pzn.validation.entity.Person;

public class ConstraintDescriptorTest extends AbstractValidatorTest{

    @Test
    void test() {
        Person person = new Person();

        validate(person);
    }
}
