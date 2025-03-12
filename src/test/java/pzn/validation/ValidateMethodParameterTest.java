package pzn.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.Person;

import java.lang.reflect.Method;
import java.util.Set;

public class ValidateMethodParameterTest extends AbstractValidatorTest{

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "";

        Method method = person.getClass().getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateParameters(person, method, new Object[]{name});

        for (var violation : violations){
            System.out.println(" ");
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
        }
    }

    @Test
    void testGetFullName() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        Method method = person.getClass().getMethod("getFullName");

        String returnVal = person.getFullName();

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateReturnValue(person, method, returnVal);

        for (var violation : violations){
            System.out.println(" ");
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
        }
    }
}
