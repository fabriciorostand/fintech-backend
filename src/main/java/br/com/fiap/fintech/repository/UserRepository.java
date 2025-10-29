package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}