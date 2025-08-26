package br.com.fiap.fintech.model;

import java.math.BigDecimal;

public class BankAccount {
    int id;
    User user;
    Branch branch;
    int number;
    BigDecimal balance;

    public BankAccount() {

    }

    public BankAccount(User user, Branch branch, int number) {
        this.user = user;
        this.branch = branch;
        this.number = number;
    }

    public BankAccount(int id, User user, Branch branch, int number, BigDecimal balance) {
        this.id = id;
        this.user = user;
        this.branch = branch;
        this.number = number;
        this.balance = balance;
    }

    public void displayBankAccount() {
        branch.bank.displayBank();
        branch.displayBranch();
        System.out.println("Número da Conta: " + number);
    }

    public void checkBalance() {
        System.out.println("Consultando saldo...");
    }
}