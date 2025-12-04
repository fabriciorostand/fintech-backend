package br.com.fiap.fintech.dto.transaction;

import br.com.fiap.fintech.model.Transaction;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TransactionResponse {
    private Long id;
    private Long bankAccountId;
    private Long transactionTypeId;
    private Long transactionCategoryId;
    private String name;
    private BigDecimal value;
    private LocalDate date;
    private String description;

    // Construtor que converte Transaction para TransactionResponse
    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.bankAccountId = transaction.getBankAccountId();
        this.transactionTypeId = transaction.getTransactionTypeId();
        this.transactionCategoryId = transaction.getTransactionCategoryId();
        this.name = transaction.getName();
        this.value = transaction.getValue();
        this.date = transaction.getDate();
        this.description = transaction.getDescription();
    }
}