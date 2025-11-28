package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    // Attributes
    private final BankAccountRepository bankAccountRepository;

    // Methods
    @Transactional
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

    public List<BankAccount> findByUserId(int userId) {
        return bankAccountRepository.findByUserId(userId);
    }

    public BankAccount update(int id, BankAccount bankAccount) {
        Optional<BankAccount> existent = bankAccountRepository.findById(id);

        if (existent.isPresent()) {
            BankAccount existingAccount = existent.get();
            // Update only mutable fields
            existingAccount.setNumber(bankAccount.getNumber());
            // Note: userId should not be updated as the user relationship is immutable
            return bankAccountRepository.save(existingAccount);
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