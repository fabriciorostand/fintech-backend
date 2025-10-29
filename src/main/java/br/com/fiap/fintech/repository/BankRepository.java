package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}