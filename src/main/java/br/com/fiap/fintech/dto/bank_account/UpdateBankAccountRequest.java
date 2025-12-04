package br.com.fiap.fintech.dto.bank_account;

import lombok.Getter;

@Getter
public class UpdateBankAccountRequest {
    private Long branchId;

    private Long bankId;

    private String number;
}