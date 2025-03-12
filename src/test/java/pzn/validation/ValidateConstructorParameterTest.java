package pzn.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Address;
import pzn.validation.entity.Person;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ValidateConstructorParameterTest extends AbstractValidatorTest{

    @Test
    void Parameter() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateConstructorParameters(constructor, new Object[]{"", "", null});

        for (var violation : violations){
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }

    @Test
    void ReturnVal() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);
        Person person = new Person("", "", null);

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateConstructorReturnValue(constructor, person);

        for (var violation : violations){
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }
}
