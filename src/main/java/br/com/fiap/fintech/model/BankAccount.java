package br.com.fiap.fintech.model;

import br.com.fiap.fintech.dto.bank_account.CreateBankAccountRequest;
import br.com.fiap.fintech.dto.bank_account.UpdateBankAccountRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_FIN_CONTA_BANCARIA")
@Getter @Setter
@NoArgsConstructor
public class BankAccount {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_FIN_CONTA_BANCARIA_SEQ")
    @SequenceGenerator(name = "T_FIN_CONTA_BANCARIA_SEQ", sequenceName = "T_FIN_CONTA_BANCARIA_SEQ", allocationSize = 1)
    @Column(name = "ID_CONTA_BANCARIA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    private User user;

    @Column(name = "ID_USUARIO")
    private Long userId;

    @Column(name = "ID_AGENCIA")
    private Long branchId;

    @Column(name = "ID_BANCO")
    private Long bankId;

    @Column(name = "NR_CONTA_BANCARIA")
    private String number;

    @Column(name = "VL_SALDO_ATUAL")
    private BigDecimal balance;

    @OneToMany(mappedBy = "bankAccountId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public BankAccount(CreateBankAccountRequest request) {
        this.userId = request.getUserId();
        this.branchId = request.getBranchId();
        this.bankId = request.getBankId();
        this.number = request.getNumber();
        this.balance = request.getBalance();
    }

    public void updateInfo(UpdateBankAccountRequest request) {
        if (request.getBranchId() != null) {
            this.branchId = request.getBranchId();
        }

        if (request.getBankId() != null) {
            this.bankId = request.getBankId();
        }

        if (request.getNumber() != null) {
            this.number = request.getNumber();
        }
    }
}