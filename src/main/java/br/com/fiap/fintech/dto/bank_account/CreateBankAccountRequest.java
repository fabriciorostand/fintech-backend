package br.com.fiap.fintech.dto.bank_account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateBankAccountRequest {
    @NotNull(message = "{userId.required}")
    private Long userId;

    @NotNull(message = "{branchId.required}")
    private Long branchId;

    @NotNull(message = "{bankId.required}")
    private Long bankId;

    @NotBlank(message = "{number.required}")
    @Pattern(regexp = "\\d{8,13}", message = "{number.invalid}")
    private String number;

    @NotNull(message = "{balance.required}")
    private BigDecimal balance;
}