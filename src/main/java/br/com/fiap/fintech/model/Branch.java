package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_AGENCIA")
public class Branch {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_AGENCIA_SEQ")
    @SequenceGenerator(name = "T_FIN_AGENCIA_SEQ", sequenceName = "T_FIN_AGENCIA_SEQ", allocationSize = 1)
    @Column(name = "ID_AGENCIA")
    private int id;

    @Column(name = "ID_BANCO")
    private int bankId;


    @Column(name = "NR_AGENCIA")
    private int number;

    // Getters
    public int getId() {
        return id;
    }

    public int getBankId() {
        return bankId;
    }

    public int getNumber() {
        return number;
    }

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    // Constructors
    public Branch() {

    }

    public Branch(int number) {
        this.number = number;
    }

    public Branch(int number, int bankId) {
        this.number = number;
        this.bankId = bankId;
    }

    public Branch(int id, int bankId, int number) {
        this.id = id;
        this.bankId = bankId;
        this.number = number;
    }

    // Methods
    public void displayBranch() {
        System.out.println("Número da Agência: " + getNumber());
    }
}