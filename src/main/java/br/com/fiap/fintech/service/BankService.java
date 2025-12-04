package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService {
    // Attributes
    private final BankRepository bankRepository;

    // Methods
    @Transactional
    public Bank register(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank findById(Long id) {
        Optional<Bank> bank = bankRepository.findById(id);

        if (bank.isPresent()) {
            return bank.get();
        } else {
            throw new RuntimeException("Banco não encontrado!");
        }
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Bank update(Long id, Bank bank) {
        Optional<Bank> existent = bankRepository.findById(id);

        if (existent.isPresent()) {
            return bankRepository.save(bank);
        } else {
            throw new RuntimeException("Erro ao atualizar: banco não encontrado!");
        }
    }

    public void delete(Long id) {
        Optional<Bank> bank = bankRepository.findById(id);

        if (bank.isPresent()) {
            bankRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: banco não encontrado!");
        }
    }
}