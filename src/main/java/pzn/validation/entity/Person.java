package pzn.validation.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    @NotBlank(message = "First name can not blank")
    @Size(max = 20, message = "First name length max mus 100 characters")
    private String firstName;

    @NotBlank(message = "Last name can not blank")
    @Size(max = 20, message = "Last name length max mus 100 characters")
    private String lastName;

    @NotNull(message = "Address can not null")
    @Valid
    public Address address;

    private List<@NotBlank(message = "Hobbies must not blank") String> hobbies;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public void sayHello(@NotBlank(message = "name must not blank") String name){
        System.out.println("Hi " + name + ", my name is " + this.firstName);
    }

    @NotBlank(message = "NotBlank")
    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Valid
    public Person() {
    }

    public Person(@NotBlank(message = "First name must not blank") String firstName,
                  @NotBlank(message = "Last name must not blank") String lastName,
                  @NotNull(message = "Address must not blank") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
