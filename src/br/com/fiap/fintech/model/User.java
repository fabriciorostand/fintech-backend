package br.com.fiap.fintech.model;

public class User {
    public int id;
    public String name;
    public String email;
    public String password;
    public boolean logged = false;

    public User() {

    }

    public User(int id, String name, String email, String password, boolean logged) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.logged = logged;
    }

    public void displayUser() {
            System.out.println("\nNome: " + name);
            System.out.println("E-mail: " + email);
    }
}