package br.com.fiap.fintech.security;

import lombok.Getter;

@Getter
public class TokenJWTResponse {
    private String token;

    // Construtor que converte o token para TokenJWTResponse
    public TokenJWTResponse(String token) {
        this.token = token;
    }
}