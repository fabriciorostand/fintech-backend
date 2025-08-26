package br.com.fiap.fintech.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    int id;
    BankAccount bankAccount;
    TransactionType type;
    Category category;
    String name;
    BigDecimal value;
    LocalDateTime date;
    String description;

    public Transaction() {

    }

    public Transaction(int id, BankAccount bankAccount, TransactionType type, Category category, String name, BigDecimal value, LocalDateTime date, String description) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.type = type;
        this.category = category;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }
}