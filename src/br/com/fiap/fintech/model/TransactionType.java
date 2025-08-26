package br.com.fiap.fintech.model;

public class TransactionType {
    public int id;
    public String name;

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