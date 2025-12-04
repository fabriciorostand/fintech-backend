package br.com.fiap.fintech.model;

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
}
