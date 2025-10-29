package br.com.fiap.fintech.model;

public class Bank {
    // Attributes
    private int id;
    private String name;
    private int number;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Constructors
    public Bank() {

    }

    public Bank(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
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