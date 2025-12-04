package br.com.fiap.fintech.dto.bank_account;

import br.com.fiap.fintech.model.BankAccount;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BankAccountResponse {
    private Long id;
    private Long userId;
    private Long branchId;
    private Long bankId;
    private String number;
    private BigDecimal balance;

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