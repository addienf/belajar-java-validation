package pzn.validation.entity;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank(message = "Address street can not blank")
    private String street;

    @NotBlank(message = "Address city can not blank")
    private String city;

    @NotBlank(message = "Address country can not blank")
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
