package com.outfit.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PersonsDto {

    // == fields ==

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private int zipcode;
    private String countrycode;

    // == constructors ==

    public PersonsDto() {}
}
