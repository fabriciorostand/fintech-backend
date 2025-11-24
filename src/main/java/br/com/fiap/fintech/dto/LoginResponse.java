package br.com.fiap.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginResponse {
    // Attributes
    private boolean success;
    private String message;
    private Integer userId;
    private String userName;
}