package pzn.validation.service;

import jakarta.validation.constraints.NotBlank;
import pzn.validation.constraint.CheckPasswordParameter;


public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,

            reTypePasswordParam = 2
    )
    public void register(
        @NotBlank(message = "Username must not blank") String username,
        @NotBlank(message = "Password must not blank") String password,
        @NotBlank(message = "Password must not blank") String reTypePassword
    ){

    }
}
