package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.repository.BankAccountRepository;
import br.com.fiap.fintech.repository.TransactionRepository;
import br.com.fiap.fintech.repository.TransactionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    // Attributes
    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final UserService userService;
    private final BankAccountService bankAccountService;

    // Methods
    @Transactional
    public Transaction register(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        updateAccountBalanceForNewTransaction(savedTransaction);
        return savedTransaction;
    }

    public Transaction findById(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()) {
            return transaction.get();
        } else {
            throw new RuntimeException("Transação não encontrada!");
        }
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Page<Transaction> findByBankAccountId(int bankAccountId, Pageable pageable) {
        return transactionRepository.findByBankAccountId(bankAccountId, pageable);
    }

    public Page<Transaction> findByUserId(int userId, Pageable pageable) {
        return transactionRepository.findByBankAccount_UserId(userId, pageable);
    }

    public Page<Transaction> findByUserIdAndTransactionTypeId(int userId, int transactionTypeId, Pageable pageable) {
        // Valida se o usuário existe
        userService.findById(userId);

        return transactionRepository.findByBankAccount_UserIdAndTransactionTypeId(userId, transactionTypeId, pageable);
    }

    public Page<Transaction> findByBankAccountIdAndTransactionTypeId(int bankAccountId, int transactionTypeId, Pageable pageable) {
        return transactionRepository.findByBankAccountIdAndTransactionTypeId(bankAccountId, transactionTypeId, pageable);
    }

    @Transactional
    public Transaction update(int id, Transaction transaction) {
        Optional<Transaction> existent = transactionRepository.findById(id);

        if (existent.isPresent()) {
            Transaction oldTransaction = existent.get();
            
            // Reverte o efeito da transação antiga
            revertAccountBalanceForTransaction(oldTransaction);
            
            // Salva a nova transação
            Transaction updatedTransaction = transactionRepository.save(transaction);
            
            // Aplica o efeito da nova transação
            updateAccountBalanceForNewTransaction(updatedTransaction);
            
            return updatedTransaction;
        } else {
            throw new RuntimeException("Erro ao atualizar: transação não encontrada!");
        }
    }

    @Transactional
    public void delete(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()) {
            // Reverte o efeito da transação antes de excluí-la
            revertAccountBalanceForTransaction(transaction.get());
            transactionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: transação não encontrada!");
        }
    }

    private void updateAccountBalanceForNewTransaction(Transaction transaction) {
        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionTypeId())
                .orElseThrow(() -> new RuntimeException("Tipo de transação não encontrado!"));
        
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
                .orElseThrow(() -> new RuntimeException("Tipo de transação não encontrado!"));
        
        String typeName = transactionType.getName().toLowerCase();
        
        // Reverte o efeito: se foi receita, subtrai; se foi despesa, adiciona
        if (typeName.contains("receita") || typeName.contains("entrada") || typeName.contains("credito")) {
            bankAccountService.subtractFromBalance(transaction.getBankAccountId(), transaction.getValue());
        } else if (typeName.contains("despesa") || typeName.contains("saida") || typeName.contains("debito")) {
            bankAccountService.addToBalance(transaction.getBankAccountId(), transaction.getValue());
        }
    }
}