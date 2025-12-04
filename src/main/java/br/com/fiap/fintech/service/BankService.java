package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.bank.CreateBankRequest;
import br.com.fiap.fintech.dto.bank.UpdateBankRequest;
import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.repository.BankRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public Bank register(CreateBankRequest request) {
        Bank bank = new Bank(request);

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

    @Transactional
    public Bank update(Long id, UpdateBankRequest request) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Banco não encontrado"));

        bank.updateInfo(request);

        return bank;
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