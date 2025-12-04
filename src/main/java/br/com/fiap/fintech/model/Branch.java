package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.branch.CreateBranchRequest;
import br.com.fiap.fintech.dto.branch.UpdateBranchRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_FIN_AGENCIA")
@Getter @Setter
@NoArgsConstructor
public class Branch {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_AGENCIA_SEQ")
    @SequenceGenerator(name = "T_FIN_AGENCIA_SEQ", sequenceName = "T_FIN_AGENCIA_SEQ", allocationSize = 1)
    @Column(name = "ID_AGENCIA")
    private Long id;

    @Column(name = "ID_BANCO")
    private Long bankId;

    @Column(name = "NR_AGENCIA")
    private String number;

    public Branch(CreateBranchRequest request) {
        this.bankId = request.getBankId();
        this.number = request.getNumber();
    }

    public void updateInfo(UpdateBranchRequest request) {
            this.number = request.getNumber();
    }
}