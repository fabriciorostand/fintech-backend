package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_CATEGORIA_LANCAMENTO")
public class TransactionCategory {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_CATEGORIA_LANCAMENTO_SEQ")
    @SequenceGenerator(name = "T_FIN_CATEGORIA_LANCAMENTO_SEQ", sequenceName = "T_FIN_CATEGORIA_LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_CATEGORIA_LANCAMENTO")
    private int id;

    @Column(name = "NM_CATEGORIA_LANCAMENTO")
    private String name;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    // Constructors
    public TransactionCategory() {

    }

    public TransactionCategory(String name) {
        this.name = name;
    }

    public TransactionCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Methods
    public void displayTransactionCategory() {
        System.out.println("Categoria: " + getName());
    }
}