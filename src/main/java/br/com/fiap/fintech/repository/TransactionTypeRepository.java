package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}