package br.com.fiap.fintech.model;

public class Category {
    public int id;
    public String name;

    public Category() {

    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayCategory() {
        System.out.println("Categoria: " + name);
    }
}