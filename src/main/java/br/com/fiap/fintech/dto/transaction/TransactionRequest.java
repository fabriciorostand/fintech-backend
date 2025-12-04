package br.com.fiap.fintech.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TransactionRequest {
    @NotNull
    private Long bankAccountId;

    @NotNull
    private Long transactionTypeId;

    @NotNull
    private Long transactionCategoryId;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull @PastOrPresent
    private LocalDate date;

    private String description;
}
