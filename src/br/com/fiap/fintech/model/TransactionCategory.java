package br.com.fiap.fintech.model;

public class TransactionCategory {
    private int id;
    private String name;

    // Getters
    public String getName() {
        return name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public TransactionCategory() {

    }

    public TransactionCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayTransactionCategory() {
        System.out.println("Categoria: " + name);
    }
}