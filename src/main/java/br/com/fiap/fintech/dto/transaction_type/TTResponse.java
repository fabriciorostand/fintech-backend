package br.com.fiap.fintech.dto.transaction_type;

import br.com.fiap.fintech.model.TransactionType;
import lombok.Getter;

@Getter
public class TTResponse {
    private Long id;
    private String name;

    public TTResponse(TransactionType transactionType) {
        this.id = transactionType.getId();
        this.name = transactionType.getName();
    }
}