package br.com.fiap.fintech.model;

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
    private int id;

    @Column(name = "ID_BANCO")
    private int bankId;

    @Column(name = "NR_AGENCIA")
    private String number;
}