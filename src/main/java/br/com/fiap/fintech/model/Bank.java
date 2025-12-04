package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.bank.CreateBankRequest;
import br.com.fiap.fintech.dto.bank.UpdateBankRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_FIN_BANCO")
@Getter @Setter
@NoArgsConstructor
public class Bank {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_BANCO_SEQ")
    @SequenceGenerator(name = "T_FIN_BANCO_SEQ", sequenceName = "T_FIN_BANCO_SEQ", allocationSize = 1)
    @Column(name = "ID_BANCO")
    private Long id;

    @Column(name = "NM_BANCO")
    private String name;

    @Column(name = "NR_BANCO")
    private String number;

    public Bank(CreateBankRequest request) {
        this.name = request.getName();
        this.number = request.getNumber();
    }

    public void updateInfo(UpdateBankRequest request) {
        if (request.getName() != null) {
            this.name = request.getName();
        }

        if (request.getNumber() != null) {
            this.number = request.getNumber();
        }
    }
}