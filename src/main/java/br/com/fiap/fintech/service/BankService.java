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
        return bankRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Transactional
    public Bank update(Long id, UpdateBankRequest request) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        bank.updateInfo(request);

        return bank;
    }

    @Transactional
    public void delete(Long id) {
        bankRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        bankRepository.deleteById(id);
    }
}