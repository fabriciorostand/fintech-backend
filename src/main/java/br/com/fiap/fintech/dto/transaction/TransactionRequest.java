package br.com.fiap.fintech.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TransactionRequest {
    @NotNull(message = "{bankAccountId.required}")
    private Long bankAccountId;

    @NotNull(message = "{transactionTypeId.required}")
    private Long transactionTypeId;

    @NotNull(message = "{transactionCategoryId.required}")
    private Long transactionCategoryId;

    @NotBlank(message = "{name.required}")
    private String name;

    @NotNull(message = "{value.required}")
    private BigDecimal value;

    @NotNull(message = "{date.required}")
    @PastOrPresent(message = "{date.invalid}")
    private LocalDate date;

    private String description;
}
