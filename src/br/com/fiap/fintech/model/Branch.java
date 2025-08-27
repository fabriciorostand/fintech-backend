package br.com.fiap.fintech.model;

public class Branch {
    public int id;
    public Bank bank;
    public int number;

    public Branch() {

    }

    public Branch(Bank bank, int number) {
        this.bank = bank;
        this.number = number;
    }

    public Branch(int id, Bank bank, int number) {
        this.id = id;
        this.bank = bank;
        this.number = number;
    }

    public void displayBranch() {
        System.out.println("Número da Agência: " + number);
    }
}