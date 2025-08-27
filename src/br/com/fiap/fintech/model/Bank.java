package br.com.fiap.fintech.model;

public class Bank {
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

    public Bank() {

    }

    public Bank(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void displayBank() {
        System.out.println("\nNome do banco: " + name);
        System.out.println("Número do banco: " + number);
    }
}