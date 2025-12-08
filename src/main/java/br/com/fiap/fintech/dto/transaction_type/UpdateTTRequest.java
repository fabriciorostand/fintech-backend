package br.com.fiap.fintech.dto.transaction_type;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateTTRequest {
    @NotBlank(message = "{name.required}")
    private String name;
}