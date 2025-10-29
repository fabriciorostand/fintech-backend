package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_TIPO_LANCAMENTO")
public class TransactionType {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_USUARIO_ID_USUARIO_SEQ")
    @SequenceGenerator(name = "T_FIN_USUARIO_ID_USUARIO_SEQ", sequenceName = "T_FIN_USUARIO_ID_USUARIO_SEQ", allocationSize = 1)
    @Column(name = "ID_TIPO_LANCAMENTO")
    private int id;

    @Column(name = "NM_TIPO_LANCAMENTO")
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
    public TransactionType() {

    }

    public TransactionType(String name) {
        this.name = name;
    }

    public TransactionType(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
