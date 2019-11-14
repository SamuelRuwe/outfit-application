package com.outfit.domain;

import com.outfit.dto.PersonsDto;
import com.outfit.security.PasswordUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Persons {

    // == fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String salt;
    private String securepassword;
    private String firstname;
    private String lastname;
    private String email;
    private int zipcode;
    private String countrycode;

    // == constructors ==

    public Persons() {}

    public Persons(PersonsDto personsDto) {
        this.username = personsDto.getUsername();
        this.salt = PasswordUtils.getSalt(30);
        this.securepassword = PasswordUtils.generateSecurePassword(personsDto.getPassword(), this.salt);
        this.firstname = personsDto.getUsername();
        this.lastname = personsDto.getLastname();
        this.email = personsDto.getEmail();
        this.zipcode = personsDto.getZipcode();
        this.countrycode = personsDto.getCountrycode();
    }

}
