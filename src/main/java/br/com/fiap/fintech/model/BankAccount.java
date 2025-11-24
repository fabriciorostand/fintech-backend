package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "T_FIN_CONTA_BANCARIA")
@Getter @Setter
@NoArgsConstructor
public class BankAccount {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_CONTA_BANCARIA_SEQ")
    @SequenceGenerator(name = "T_FIN_CONTA_BANCARIA_SEQ", sequenceName = "T_FIN_CONTA_BANCARIA_SEQ", allocationSize = 1)
    @Column(name = "ID_CONTA_BANCARIA")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    private User user;

    @Column(name = "ID_USUARIO")
    private int userId;

    @Column(name = "ID_AGENCIA")
    private int branchId;

    @Column(name = "ID_BANCO")
    private int bankId;

    @Column(name = "NR_CONTA_BANCARIA")
    private String number;

    @Column(name = "VL_SALDO_ATUAL")
    private double balance;

    @OneToMany(mappedBy = "bankAccountId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}