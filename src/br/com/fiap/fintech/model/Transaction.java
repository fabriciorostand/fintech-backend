package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public int id;
    public BankAccount bankAccount;
    public TransactionType type;
    public TransactionCategory category;
    public String name;
    public double value;
    public LocalDate date;
    public String description;

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

    public void LastTransaction() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            type.displayTransactionType();
            System.out.println("Nome: " + name);
            category.displayTransactionCategory();
            System.out.println("Data: " + date.format(formatter));
            System.out.println("Descrição: " + description);
            System.out.println("Valor: " + value);
    }
}