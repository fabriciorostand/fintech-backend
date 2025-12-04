package br.com.fiap.fintech.dto.transaction_category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateTCRequest {
    @NotBlank
    private String name;
}
