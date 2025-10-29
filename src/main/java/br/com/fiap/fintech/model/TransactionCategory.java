package br.com.fiap.fintech.model;

public class TransactionCategory {
    // Attributes
    private int id;
    private String name;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    // Constructors
    public TransactionCategory() {

    }

    public TransactionCategory(String name) {
        this.name = name;
    }

    public TransactionCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Methods
    public void displayTransactionCategory() {
        System.out.println("Categoria: " + getName());
    }
}