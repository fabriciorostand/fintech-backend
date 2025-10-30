package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public Bank register(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank findById(int id) {
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

    public Bank update(int id, Bank bank) {
        Optional<Bank> existent = bankRepository.findById(id);

        if (existent.isPresent()) {
            return bankRepository.save(bank);
        } else {
            throw new RuntimeException("Erro ao atualizar: banco não encontrado!");
        }
    }

    public void delete(int id) {
        Optional<Bank> bank = bankRepository.findById(id);

        if (bank.isPresent()) {
            bankRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: banco não encontrado!");
        }
    }
}