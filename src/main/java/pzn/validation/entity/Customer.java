package pzn.validation.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    @NotBlank(
            message = "Email must not blank"
    )
    @Email(
            message = "Email must valid format"
    )
    private String email;

    @NotBlank(
            message = "Name must not blank"
    )
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
