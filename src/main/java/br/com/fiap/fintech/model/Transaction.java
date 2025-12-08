package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.transaction.TransactionRequest;
import br.com.fiap.fintech.dto.transaction.UpdateTransactionRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_FIN_LANCAMENTO")
@Getter @Setter
@NoArgsConstructor
public class Transaction {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_LANCAMENTO_SEQ")
    @SequenceGenerator(name = "T_FIN_LANCAMENTO_SEQ", sequenceName = "T_FIN_LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_LANCAMENTO")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTA_BANCARIA", insertable = false, updatable = false)
    private BankAccount bankAccount;

    @Column(name = "ID_CONTA_BANCARIA")
    private Long bankAccountId;

    @Column(name = "ID_TIPO_LANCAMENTO")
    private Long transactionTypeId;

    @Column(name = "ID_CATEGORIA_LANCAMENTO")
    private Long transactionCategoryId;

    @Column(name = "NM_LANCAMENTO")
    private String name;

    @Column(name = "VL_LANCAMENTO")
    private BigDecimal value;

    @Column(name = "DT_LANCAMENTO")
    private LocalDate date;

    @Column(name = "DS_LANCAMENTO")
    private String description;

    // Construtor que inicializa uma Transaction a partir de um TransactionRequest
    public Transaction(TransactionRequest request) {
        this.bankAccountId = request.getBankAccountId();
        this.transactionTypeId = request.getTransactionTypeId();
        this.transactionCategoryId = request.getTransactionCategoryId();
        this.name = request.getName();
        this.value = request.getValue();
        this.date = request.getDate();
        this.description = request.getDescription();
    }

    public void updateInfo(UpdateTransactionRequest request) {
        if (request.getBankAccountId() != null) {
            this.bankAccountId = request.getBankAccountId();
        }

        if (request.getTransactionTypeId() != null) {
            this.transactionTypeId = request.getTransactionTypeId();
        }

        if (request.getTransactionCategoryId() != null) {
            this.transactionCategoryId = request.getTransactionCategoryId();
        }

        if (request.getName() != null) {
            this.name = request.getName();
        }

        if (request.getValue() != null) {
            this.value = request.getValue();
        }

        if (request.getDate() != null) {
            this.date = request.getDate();
        }

        if (request.getDescription() != null) {
            this.description = request.getDescription();
        }
    }
}