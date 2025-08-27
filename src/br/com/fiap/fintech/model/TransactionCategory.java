package br.com.fiap.fintech.model;

public class TransactionCategory {
    public int id;
    public String name;

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