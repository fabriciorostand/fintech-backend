package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Page<Transaction> findByBankAccountId(int bankAccountId, Pageable pageable);
    Page<Transaction> findByBankAccount_UserId(int userId, Pageable pageable);
    Page<Transaction> findByBankAccount_UserIdAndTransactionTypeId(int userId, int transactionTypeId, Pageable pageable);
    Page<Transaction> findByBankAccountIdAndTransactionTypeId(int bankAccountId, int transactionTypeId, Pageable pageable);
}