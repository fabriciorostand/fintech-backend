package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Income extends Transaction {
    // Constructors
    public Income() {
        super();
    }

    public Income(BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        super(bankAccount, category, name, value, date, description);
    }

    public Income(int id, BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        super(id, bankAccount, category, name, value, date, description);
    }

    // Methods
    @Override
    public void apply() {
        getBankAccount().setBalance(getBankAccount().getBalance() + getValue());
    }

    @Override
    public String getType() {
        return "Receita";
    }
}