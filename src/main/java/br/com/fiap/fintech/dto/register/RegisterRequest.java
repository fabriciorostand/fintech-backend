package br.com.fiap.fintech.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class RegisterRequest {
    // Attributes
    @NotBlank
    private String name;

    @Email @NotBlank
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+=\\-{}|:;\"'<>,.?/]{8,}$") @NotBlank
    private String password;
}