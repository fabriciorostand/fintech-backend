package br.com.fiap.fintech.dto.branch;

import br.com.fiap.fintech.model.Branch;
import lombok.Getter;

@Getter
public class BranchResponse {
    private Long id;
    private Long bankId;
    private String number;

    // Construtor que converte Branch para BranchResponse
    public BranchResponse(Branch branch) {
        this.id = branch.getId();
        this.bankId = branch.getBankId();
        this.number = branch.getNumber();
    }
}