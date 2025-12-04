package br.com.fiap.fintech.dto.transaction;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class UpdateTransactionRequest {
    private Long bankAccountId;

    private Long transactionTypeId;

    private Long transactionCategoryId;

    private String name;

    private BigDecimal value;

    private LocalDate date;

    private String description;
}
