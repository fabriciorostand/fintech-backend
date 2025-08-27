package br.com.fiap.fintech.model;

public class Bank {
    public int id;
    public String name;
    public int number;

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