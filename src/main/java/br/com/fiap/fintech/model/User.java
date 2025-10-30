package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_USUARIO")
public class User {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_USUARIO_SEQ")
    @SequenceGenerator(name = "T_FIN_USUARIO_SEQ", sequenceName = "T_FIN_USUARIO_SEQ", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private int id;

    @Column(name = "NM_USUARIO")
    private String name;

    @Column(name = "EM_USUARIO")
    private String email;

    @Column(name = "SH_USUARIO")
    private String password;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    // Constructors
    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Methods

}