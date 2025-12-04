package br.com.fiap.fintech.dto.login;

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
    private Long userId;
    private String userName;
}