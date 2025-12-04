package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}