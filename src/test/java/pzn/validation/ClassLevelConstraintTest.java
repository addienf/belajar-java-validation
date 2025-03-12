package pzn.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Person;
import pzn.validation.entity.Register;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClassLevelConstraintTest extends AbstractValidatorTest{

    @Test
    void test() {
        Register register = new Register();
        register.setPassword("123");
        register.setReTypePassword("12334");

        validate(register);
    }

    @Test
    void container() {
        Person person = new Person();
        person.setFirstName("addien");
        person.setLastName("fauzan");

        person.setHobbies(List.of("", "Dua", "Tiga"));

        validate(person);

    }
}
