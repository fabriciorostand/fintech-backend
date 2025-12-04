package br.com.fiap.fintech.dto.transaction_category;

import br.com.fiap.fintech.model.TransactionCategory;
import lombok.Getter;

@Getter
public class TCResponse {
    private Long id;
    private String name;

    public TCResponse(TransactionCategory transactionCategory) {
        this.id = transactionCategory.getId();
        this.name = transactionCategory.getName();
    }
}