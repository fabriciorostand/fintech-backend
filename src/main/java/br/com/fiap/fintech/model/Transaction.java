package br.com.fiap.fintech.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_FIN_LANCAMENTO")
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

    // Getters
    public int getId() {
        return id;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public int getTransactionCategoryId() {
        return transactionCategoryId;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructors
    public Transaction() {

    }

    public Transaction(int bankAccountId, int transactionTypeId, int transactionCategoryId, String name, double value, LocalDate date, String description) {
        this.bankAccountId = bankAccountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionCategoryId = transactionCategoryId;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    public Transaction(int id, int bankAccountId, int transactionTypeId, int transactionCategoryId, String name, double value, LocalDate date, String description) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.transactionTypeId = transactionTypeId;
        this.transactionCategoryId = transactionCategoryId;
        this.name = name;
        this.value = value;
        this.date = date;
        this.description = description;
    }

    // Methods

}