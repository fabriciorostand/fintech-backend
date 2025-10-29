package br.com.fiap.fintech.model;

public class Branch {
    // Attributes
    private int id;
    private int bankId;
    private Bank bank;
    private int number;

    // Getters
    public int getId() {
        return id;
    }

    public int getBankId() {
        return bankId;
    }

    public Bank getBank() {
        return bank;
    }

    public int getNumber() {
        return number;
    }

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    // Constructors
    public Branch() {

    }

    public Branch(int number) {
        this.number = number;
    }

    public Branch(int number, int bankId) {
        this.number = number;
        this.bankId = bankId;
    }

    public Branch(Bank bank, int number) {
        this.bank = bank;
        this.number = number;
    }

    public Branch(int id, int bankId, int number) {
        this.id = id;
        this.bankId = bankId;
        this.number = number;
    }

    public Branch(int id, Bank bank, int number) {
        this.id = id;
        this.bank = bank;
        this.number = number;
    }

    // Methods
    public void displayBranch() {
        System.out.println("Número da Agência: " + getNumber());
    }
}
