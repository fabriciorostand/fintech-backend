package br.com.fiap.fintech.model;

public class Bank {
    // Attributes
    private int id;
    private String name;
    private int number;

    // Getters
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // Constructors
    public Bank() {

    }

    public Bank(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // Methods
    public void displayBank() {
        System.out.println("\nNome do banco: " + getName());
        System.out.println("Número do banco: " + getNumber());
    }
}