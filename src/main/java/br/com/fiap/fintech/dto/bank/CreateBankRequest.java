package br.com.fiap.fintech.dto.bank;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateBankRequest {
    @NotBlank
    private String name;

    @Pattern(regexp = "\\d{3}") @NotBlank
    private String number;
}
