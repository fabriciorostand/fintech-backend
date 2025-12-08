package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.bank_account.CreateBankAccountRequest;
import br.com.fiap.fintech.dto.bank_account.UpdateBankAccountRequest;
import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.repository.BankAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    // Attributes
    private final BankAccountRepository bankAccountRepository;

    // Methods
    @Transactional
    public BankAccount register(CreateBankAccountRequest request) {
        BankAccount bankAccount = new BankAccount(request);

        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    public List<BankAccount> findByUserId(Long userId) {
        return bankAccountRepository.findByUserId(userId);
    }

    @Transactional
    public BankAccount update(Long id, UpdateBankAccountRequest request) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        // Update only mutable fields
        bankAccount.updateInfo(request);

        return bankAccount;
    }

    @Transactional
    public void delete(Long id) {
        bankAccountRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        bankAccountRepository.deleteById(id);
    }

    @Transactional
    public void updateBalance(Long accountId, BigDecimal amount) {
        BankAccount account = findById(accountId);
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);
        bankAccountRepository.save(account);
    }

    @Transactional
    public void addToBalance(Long accountId, BigDecimal amount) {
        updateBalance(accountId, amount);
    }

    @Transactional
    public void subtractFromBalance(Long accountId, BigDecimal amount) {
        updateBalance(accountId, amount.negate());
    }
}