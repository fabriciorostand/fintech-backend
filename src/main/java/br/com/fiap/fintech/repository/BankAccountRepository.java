package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}