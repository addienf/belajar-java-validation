package pzn.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import pzn.validation.service.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterConstraintTest extends AbstractValidatorTest{

    @Test
    void test() throws NoSuchMethodException {
        UserService userService = new UserService();
        Class<? extends UserService> usClass = userService.getClass();
        Method register = usClass.getMethod("register", String.class, String.class, String.class);

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, register, new Object[]{
                        "username", "password", "repassword"
                });

        for (var violation : violations){
            System.out.println(" ");
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
        }
    }
}
