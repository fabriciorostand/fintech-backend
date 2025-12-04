package br.com.fiap.fintech.dto.bank_account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateBankAccountRequest {
    @NotNull
    private Long userId;

    @NotNull
    private Long branchId;

    @NotNull
    private Long bankId;

    @NotBlank
    private String number;

    @NotNull
    private BigDecimal balance;
}