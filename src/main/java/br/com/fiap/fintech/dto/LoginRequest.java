package br.com.fiap.fintech.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LoginRequest {
    // Attributes
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}