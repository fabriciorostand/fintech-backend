package br.com.fiap.fintech.dto.bank;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateBankRequest {
    @NotBlank(message = "{name.required}")
    private String name;

    @NotBlank(message = "{number.required}")
    @Pattern(regexp = "\\d{3}", message = "{number.invalid}")
    private String number;
}
