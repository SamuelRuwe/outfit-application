package com.outfit.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoginDto {

    // == fields ==

    private int id;
    private String email;
    private String password;

    // == constructors ==

    public LoginDto() {}

}
