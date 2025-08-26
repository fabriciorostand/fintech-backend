package br.com.fiap.fintech.model;

public class BankAccount {
    int id;
    User user;
    Branch branch;
    int number;
    double balance = 2000;

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

    public double makeTransaction(Transaction transaction) {
        if (transaction.type.name.equals("Receita")) {
            return balance += transaction.value;
        }
        if (transaction.type.name.equals("Despesa")) {
            return balance -= transaction.value;
        }
        return balance;
    }

    public void displayBankAccount() {
        branch.bank.displayBank();
        branch.displayBranch();
        System.out.println("Número da Conta: " + number);
    }

    public void checkBalance() {
        System.out.println("\nSaldo: " + balance);
    }
}