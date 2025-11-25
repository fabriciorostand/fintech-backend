package br.com.fiap.fintech.dto;

import lombok.Getter;

@Getter
public class UserRequest {
    private String name;
    private String email;
    private String password;
}