package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_FIN_CONTA_BANCARIA")
public class BankAccount {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_CONTA_BANCARIA_SEQ")
    @SequenceGenerator(name = "T_FIN_CONTA_BANCARIA_SEQ", sequenceName = "T_FIN_CONTA_BANCARIA_SEQ", allocationSize = 1)
    @Column(name = "ID_CONTA_BANCARIA")
    private int id;

    @Column(name = "ID_USUARIO")
    private int userId;

    @Column(name = "ID_AGENCIA")
    private int branchId;

    @Column(name = "ID_BANCO")
    private int bankId;

    @Column(name = "NR_CONTA_BANCARIA")
    private String number;

    @Column(name = "VL_SALDO_ATUAL")
    private double balance = 2000;

    @OneToMany(mappedBy = "bankAccountId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    //Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBranchId() {
        return branchId;
    }

    public int getBankId() {
        return bankId;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Constructors
    public BankAccount() {

    }

    public BankAccount(int id, String number, double balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public BankAccount(int userId, int branchId, int bankId, String number, double balance) {
        this.userId = userId;
        this.branchId = branchId;
        this.bankId = bankId;
        this.number = number;
        this.balance = balance;
    }

    public BankAccount(int id, int userId, int branchId, int bankId, String number, double balance) {
        this.id = id;
        this.userId = userId;
        this.branchId = branchId;
        this.bankId = bankId;
        this.number = number;
        this.balance = balance;
    }

    // Methods
    public void checkBalance() {
        System.out.println("\nSaldo: " + getBalance());
    }
}