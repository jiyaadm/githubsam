package com.User.Model;

public class JwtAuthResponse {
    private final String jwt;

    public JwtAuthResponse(String jwt){
        this.jwt=jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
