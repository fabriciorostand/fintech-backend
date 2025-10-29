package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}