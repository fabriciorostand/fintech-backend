package br.com.fiap.fintech.model;

public class BankAccount {
    private int id;
    private User user;
    private Branch branch;
    private int number;
    private double balance = 2000;

    //Getters
    public User getUser() {
        return user;
    }
    public Branch getBranch() {
        return branch;
    }
    public int getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }

    public BankAccount() {

    }

    public BankAccount(User user, Branch branch, int number) {
        this.user = user;
        this.branch = branch;
        this.number = number;
    }

    public BankAccount(int id, User user, Branch branch, int number, double balance) {
        this.id = id;
        this.user = user;
        this.branch = branch;
        this.number = number;
        this.balance = balance;
    }

    public void makeTransaction(Transaction transaction) {
        if (transaction.getType().getName().equalsIgnoreCase("Receita")) {
            balance += transaction.getValue();
        }
        if (transaction.getType().getName().equalsIgnoreCase("Despesa")) {
            balance -= transaction.getValue();
        }
    }

    public void displayBankAccount() {
        branch.getBank().displayBank();
        branch.displayBranch();
        System.out.println("Número da Conta: " + number);
    }

    public void checkBalance() {
        System.out.println("\nSaldo: " + balance);
    }

    public void displayLastTransaction(Transaction transaction) {
        transaction.lastTransaction();
    }
}