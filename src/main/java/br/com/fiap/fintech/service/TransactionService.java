package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.transaction.TransactionRequest;
import br.com.fiap.fintech.dto.transaction.UpdateTransactionRequest;
import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.repository.TransactionRepository;
import br.com.fiap.fintech.repository.TransactionTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    // Attributes
    private final TransactionRepository transactionRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final UserService userService;
    private final BankAccountService bankAccountService;

    // Methods
    @Transactional
    public Transaction register(TransactionRequest request) {
        Transaction transaction = new Transaction(request);

        transactionRepository.save(transaction);

        updateAccountBalanceForNewTransaction(transaction);

        return transaction;
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Page<Transaction> findByBankAccountId(Long bankAccountId, Pageable pageable) {
        return transactionRepository.findByBankAccountId(bankAccountId, pageable);
    }

    public Page<Transaction> findByUserId(Long userId, Pageable pageable) {
        return transactionRepository.findByBankAccount_UserId(userId, pageable);
    }

    public Page<Transaction> findByUserIdAndTransactionTypeId(Long userId, Long transactionTypeId, Pageable pageable) {
        // Valida se o usuário existe
        userService.findById(userId);

        return transactionRepository.findByBankAccount_UserIdAndTransactionTypeId(userId, transactionTypeId, pageable);
    }

    public Page<Transaction> findByBankAccountIdAndTransactionTypeId(Long bankAccountId, Long transactionTypeId, Pageable pageable) {
        return transactionRepository.findByBankAccountIdAndTransactionTypeId(bankAccountId, transactionTypeId, pageable);
    }

    @Transactional
    public Transaction update(Long id, UpdateTransactionRequest request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

            
            // Reverte o efeito da transação antiga
            revertAccountBalanceForTransaction(transaction);
            
            // Atualiza a transação
            transaction.updateInfo(request);
            
            // Aplica o efeito transação atualizada
            updateAccountBalanceForNewTransaction(transaction);
            
            return transaction;
    }

    @Transactional
    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        // Reverte o efeito da transação antes de excluí-la
        revertAccountBalanceForTransaction(transaction);

        transactionRepository.deleteById(id);
    }

    private void updateAccountBalanceForNewTransaction(Transaction transaction) {
        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionTypeId())
                .orElseThrow(RuntimeException::new);
        
        String typeName = transactionType.getName().toLowerCase();
        
        // Se for receita/entrada, adiciona ao saldo; se for despesa/saída, subtrai do saldo
        if (typeName.contains("receita") || typeName.contains("entrada") || typeName.contains("credito")) {
            bankAccountService.addToBalance(transaction.getBankAccountId(), transaction.getValue());
        } else if (typeName.contains("despesa") || typeName.contains("saida") || typeName.contains("debito")) {
            bankAccountService.subtractFromBalance(transaction.getBankAccountId(), transaction.getValue());
        }
    }

    private void revertAccountBalanceForTransaction(Transaction transaction) {
        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionTypeId())
                .orElseThrow(RuntimeException::new);
        
        String typeName = transactionType.getName().toLowerCase();
        
        // Reverte o efeito: se foi receita, subtrai; se foi despesa, adiciona
        if (typeName.contains("receita") || typeName.contains("entrada") || typeName.contains("credito")) {
            bankAccountService.subtractFromBalance(transaction.getBankAccountId(), transaction.getValue());
        } else if (typeName.contains("despesa") || typeName.contains("saida") || typeName.contains("debito")) {
            bankAccountService.addToBalance(transaction.getBankAccountId(), transaction.getValue());
        }
    }
}