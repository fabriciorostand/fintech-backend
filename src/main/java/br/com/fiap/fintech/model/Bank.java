package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_BANCO")
public class Bank {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_BANCO_SEQ")
    @SequenceGenerator(name = "T_FIN_BANCO_SEQ", sequenceName = "T_FIN_BANCO_SEQ", allocationSize = 1)
    @Column(name = "ID_BANCO")
    private int id;

    @Column(name = "NM_BANCO")
    private String name;

    @Column(name = "NR_BANCO")
    private String number;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Constructors
    public Bank() {

    }

    public Bank(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Bank(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // Methods
    public void displayBank() {
        System.out.println("\nNome do banco: " + getName());
        System.out.println("Número do banco: " + getNumber());
    }
}