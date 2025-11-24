package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "T_FIN_USUARIO")
@Getter @Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankAccount> bankAccounts;
}