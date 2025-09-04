package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Expense extends Transaction {
    // Constructors
    public Expense() {
        super();
    }

    public Expense(BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        super(bankAccount, category, name, value, date, description);
    }

    public Expense(int id, BankAccount bankAccount, TransactionCategory category, String name, double value, LocalDate date, String description) {
        super(id, bankAccount, category, name, value, date, description);
    }

    // Methods
    @Override
    public void apply() {
        getBankAccount().setBalance(getBankAccount().getBalance() - getValue());
    }

    @Override
    public String getType() {
        return "Despesa";
    }
}