package br.com.fiap.fintech.dto.bank;

import br.com.fiap.fintech.model.Bank;
import lombok.Getter;

@Getter
public class BankResponse {
    private Long id;
    private String name;
    private String number;

    public BankResponse(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.number = bank.getNumber();
    }
}