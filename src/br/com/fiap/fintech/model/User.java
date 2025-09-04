package br.com.fiap.fintech.model;

public class User {
    // Attributes
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean logged = false;

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLogged() {
        return logged;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    // Constructors
    public User() {

    }

    public User(int id, String name, String email, String password, boolean logged) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.logged = logged;
    }

    // Methods
    public void displayUser() {
            System.out.println("\nNome: " + getName());
            System.out.println("E-mail: " + getEmail());
    }
}