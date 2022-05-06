package com.example.ex1_managementapartmentbuilding.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRespone {
    private String email;
    private String accessToken;

    public AuthenticationRespone() { }

    public AuthenticationRespone(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }
}
