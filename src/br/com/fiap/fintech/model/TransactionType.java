package br.com.fiap.fintech.model;

public class TransactionType {
    int id;
    String name;

    public TransactionType() {

    }

    public TransactionType(int id, String name) {
        this.id = id;
        this.name = name;
    }
}