package br.com.fiap.fintech.model;

public class BankAccount {
    // Attributes
    private int id;
    private int userId;
    private int branchId;
    private int bankId;
    private User user;
    private Branch branch;
    private int number;
    private double balance = 2000;

    //Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBranchId() {
        return branchId;
    }

    public int getBankId() {
        return bankId;
    }

    public User getUser() {
        return user;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getNumber() {
        return number;
    }

    public String getAccountNumber() {
        return String.valueOf(number);
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Constructors
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

    public BankAccount(int userId, int branchId, int bankId, int number, double balance) {
        this.userId = userId;
        this.branchId = branchId;
        this.bankId = bankId;
        this.number = number;
        this.balance = balance;
    }

    public BankAccount(int id, int userId, int branchId, int bankId, int number, double balance) {
        this.id = id;
        this.userId = userId;
        this.branchId = branchId;
        this.bankId = bankId;
        this.number = number;
        this.balance = balance;
    }

    public BankAccount(int id, String accountNumber, double balance) {
        this.id = id;
        this.number = Integer.parseInt(accountNumber);
        this.balance = balance;
    }

    // Methods
    public void displayBankAccount() {
        branch.getBank().displayBank();
        branch.displayBranch();
        System.out.println("Número da Conta: " + getNumber());
    }

    public void checkBalance() {
        System.out.println("\nSaldo: " + getBalance());
    }
}