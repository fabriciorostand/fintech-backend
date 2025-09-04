package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {
    // Attributes
    private int id;
    private BankAccount bankAccount;
    private TransactionCategory category;
    private String name;
    private double value;
    private LocalDate date;
    private String description;

    // Getters
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

    // Methods
    public abstract void apply();

    public abstract String getType();

    public void lastTransaction() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\nTipo: " + getType());
            System.out.println("Nome: " + getName());
            category.displayTransactionCategory();
            System.out.println("Data: " + getDate().format(formatter));
            System.out.println("Descrição: " + getDescription());
            System.out.println("Valor: " + getValue());
    }
}