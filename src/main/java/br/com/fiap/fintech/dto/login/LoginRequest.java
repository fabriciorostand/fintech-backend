package br.com.fiap.fintech.dto.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LoginRequest {
    // Attributes
    @NotBlank(message = "{email.required}")
    private String email;

    @NotBlank(message = "{password.required}")
    private String password;
}