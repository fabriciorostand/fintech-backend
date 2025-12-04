package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

}