package br.com.fiap.fintech.model;

public class TransactionType {
    private int id;
    private String name;

    // Getters
    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public TransactionType() {

    }

    public TransactionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayTransactionType() {
        System.out.println("\nTipo: " + name);
    }
}