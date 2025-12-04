package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByBankAccountId(Long bankAccountId, Pageable pageable);
    Page<Transaction> findByBankAccount_UserId(Long userId, Pageable pageable);
    Page<Transaction> findByBankAccount_UserIdAndTransactionTypeId(Long userId, Long transactionTypeId, Pageable pageable);
    Page<Transaction> findByBankAccountIdAndTransactionTypeId(Long bankAccountId, Long transactionTypeId, Pageable pageable);
}