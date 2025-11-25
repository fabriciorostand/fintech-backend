package br.com.fiap.fintech.dto;

import br.com.fiap.fintech.model.BankAccount;
import lombok.Getter;

@Getter
public class BankAccountResponse {
    private int id;
    private int userId;
    private int branchId;
    private int bankId;
    private String number;
    private double balance;

    // Construtor que converte BankAccount para BankAccountResponse
    public BankAccountResponse(BankAccount bankAccount) {
        this.id = bankAccount.getId();
        this.userId = bankAccount.getUserId();
        this.branchId = bankAccount.getBranchId();
        this.bankId = bankAccount.getBankId();
        this.number = bankAccount.getNumber();
        this.balance = bankAccount.getBalance();
    }
}