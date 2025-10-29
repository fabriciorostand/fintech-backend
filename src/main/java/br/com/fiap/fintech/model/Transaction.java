package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Transaction {
    // Attributes
    private int id;
    private int bankAccountId;
    private int transactionTypeId;
    private int transactionCategoryId;
    private BankAccount bankAccount;
    private TransactionCategory category;
    private String name;
    private double value;
    private LocalDate date;
    private String description;

    // Getters
    public int getId() {
        return id;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public int getTransactionCategoryId() {
        return transactionCategoryId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setCategory(TransactionCategory category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructors
    public Transaction() {

    }

    public Transaction(BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        this.bankAccount = bankAccount;
        this.category = category;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    public Transaction(int id, BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.category = category;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    public Transaction(int bankAccountId, int transactionTypeId, int transactionCategoryId, String name, double value, LocalDate date, String description) {
        this.bankAccountId = bankAccountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionCategoryId = transactionCategoryId;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    public Transaction(int id, int bankAccountId, int transactionTypeId, int transactionCategoryId, String name, double value, LocalDate date, String description) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionCategoryId = transactionCategoryId;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    // Methods

}