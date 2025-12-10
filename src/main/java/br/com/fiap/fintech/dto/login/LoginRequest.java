package br.com.fiap.fintech.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {
    // Attributes
    @NotBlank(message = "{email.required}")
    @Email(message = "{email.login.invalid}")
    private String email;

    @NotBlank(message = "{password.required}")
    private String password;
}