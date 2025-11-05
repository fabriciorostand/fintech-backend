package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    List<BankAccount> findByUserId(int userId);
}