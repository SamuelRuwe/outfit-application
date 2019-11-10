package com.outfit.domain.TestSecondDbDomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Persons {

    // == fields ==

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    // == constructors ==
    public Persons() {}


}
