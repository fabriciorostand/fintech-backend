package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "T_FIN_LANCAMENTO")
@Getter @Setter
@NoArgsConstructor
public class Transaction {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_LANCAMENTO_SEQ")
    @SequenceGenerator(name = "T_FIN_LANCAMENTO_SEQ", sequenceName = "T_FIN_LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_LANCAMENTO")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA_BANCARIA", insertable = false, updatable = false)
    private BankAccount bankAccount;

    @Column(name = "ID_CONTA_BANCARIA")
    private int bankAccountId;

    @Column(name = "ID_TIPO_LANCAMENTO")
    private int transactionTypeId;

    @Column(name = "ID_CATEGORIA_LANCAMENTO")
    private int transactionCategoryId;

    @Column(name = "NM_LANCAMENTO")
    private String name;

    @Column(name = "VL_LANCAMENTO")
    private double value;

    @Column(name = "DT_LANCAMENTO")
    private LocalDate date;

    @Column(name = "DS_LANCAMENTO")
    private String description;
}