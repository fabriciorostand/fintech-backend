package br.com.fiap.fintech.model;

public class BankAccount {
    public int id;
    public User user;
    public Branch branch;
    public int number;
    public double balance = 2000;

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
        if (transaction.type.name.equals("Receita")) {
            balance += transaction.value;
        }
        if (transaction.type.name.equals("Despesa")) {
            balance -= transaction.value;
        }
    }

    public void displayBankAccount() {
        branch.bank.displayBank();
        branch.displayBranch();
        System.out.println("Número da Conta: " + number);
    }

    public void checkBalance() {
        System.out.println("\nSaldo: " + balance);
    }

    public void displayLastTransaction(Transaction transaction) {
        transaction.LastTransaction();
    }
}