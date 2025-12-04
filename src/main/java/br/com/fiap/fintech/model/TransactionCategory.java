package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.transaction_category.CreateTCRequest;
import br.com.fiap.fintech.dto.transaction_category.UpdateTCRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_FIN_CATEGORIA_LANCAMENTO")
@Getter @Setter
@NoArgsConstructor
public class TransactionCategory {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_CATEGORIA_LANCAMENTO_SEQ")
    @SequenceGenerator(name = "T_FIN_CATEGORIA_LANCAMENTO_SEQ", sequenceName = "T_FIN_CATEGORIA_LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_CATEGORIA_LANCAMENTO")
    private Long id;

    @Column(name = "NM_CATEGORIA_LANCAMENTO")
    private String name;

    public TransactionCategory(CreateTCRequest request) {
        this.name = request.getName();
    }

    public void updateInfo(UpdateTCRequest request) {
        this.name = request.getName();
    }
}