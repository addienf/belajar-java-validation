package pzn.validation.entity;


import jakarta.validation.constraints.NotBlank;
import pzn.validation.constraint.CheckPassword;

@CheckPassword(message = "password must same with retype password")
public class Register {

    @NotBlank(message = "Username must not blank")
    private String username;

    @NotBlank(message = "Password must not blank")
    private String password;

    @NotBlank(message = "Password must not blank")
    private String reTypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }
}
