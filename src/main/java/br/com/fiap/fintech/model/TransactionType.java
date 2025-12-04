package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.transaction_type.CreateTTRequest;
import br.com.fiap.fintech.dto.transaction_type.UpdateTTRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_FIN_TIPO_LANCAMENTO")
@Getter @Setter
@NoArgsConstructor
public class TransactionType {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_TIPO_LANCAMENTO_SEQ")
    @SequenceGenerator(name = "T_FIN_TIPO_LANCAMENTO_SEQ", sequenceName = "T_FIN_TIPO_LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_TIPO_LANCAMENTO")
    private Long id;

    @Column(name = "NM_TIPO_LANCAMENTO")
    private String name;

    public TransactionType(CreateTTRequest request) {
        this.name = request.getName();
    }

    public void updateInfo(UpdateTTRequest request) {
        this.name = request.getName();
    }
}
