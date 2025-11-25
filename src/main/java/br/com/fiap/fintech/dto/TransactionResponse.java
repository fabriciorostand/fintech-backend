package br.com.fiap.fintech.dto;

import br.com.fiap.fintech.model.Transaction;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TransactionResponse {
    private int id;
    private int bankAccountId;
    private int transactionTypeId;
    private int transactionCategoryId;
    private String name;
    private double value;
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