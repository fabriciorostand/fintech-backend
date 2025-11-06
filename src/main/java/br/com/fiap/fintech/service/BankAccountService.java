package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount register(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount findById(int id) {
        Optional<BankAccount> account = bankAccountRepository.findById(id);

        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RuntimeException("Conta bancária não encontrada!");
        }
    }

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    public BankAccount update(int id, BankAccount bankAccount) {
        Optional<BankAccount> existent = bankAccountRepository.findById(id);

        if (existent.isPresent()) {
            return bankAccountRepository.save(bankAccount);
        } else {
            throw new RuntimeException("Erro ao atualizar: conta bancária não encontrada!");
        }
    }

    public void delete(int id) {
        Optional<BankAccount> account = bankAccountRepository.findById(id);

        if (account.isPresent()) {
            bankAccountRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: conta bancária não encontrada!");
        }
    }

    @Transactional
    public void updateBalance(int accountId, double amount) {
        BankAccount account = findById(accountId);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        bankAccountRepository.save(account);
    }

    @Transactional
    public void addToBalance(int accountId, double amount) {
        updateBalance(accountId, amount);
    }

    @Transactional
    public void subtractFromBalance(int accountId, double amount) {
        updateBalance(accountId, -amount);
    }
}