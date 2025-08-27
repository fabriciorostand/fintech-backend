package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int id;
    private BankAccount bankAccount;
    private TransactionType type;
    private TransactionCategory category;
    private String name;
    private double value;
    private LocalDate date;
    private String description;

    // Getters
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public TransactionType getType() {
        return type;
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
    public void setType(TransactionType type) {
        this.type = type;
    }

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

    public Transaction() {

    }

    public Transaction(int id, BankAccount bankAccount, TransactionType type, TransactionCategory category, String name, double value, LocalDate date, String description) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.type = type;
        this.category = category;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    public void lastTransaction() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            type.displayTransactionType();
            System.out.println("Nome: " + name);
            category.displayTransactionCategory();
            System.out.println("Data: " + date.format(formatter));
            System.out.println("Descrição: " + description);
            System.out.println("Valor: " + value);
    }
}