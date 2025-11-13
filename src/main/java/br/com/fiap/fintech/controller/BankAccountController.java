package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.service.BankAccountService;
import br.com.fiap.fintech.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
@CrossOrigin(origins = "http://localhost:5173")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    private TransactionService transactionService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount register(@RequestBody BankAccount bankAccount) {
        return bankAccountService.register(bankAccount);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccount findById(@PathVariable int id) {
        return bankAccountService.findById(id);
    }

    @GetMapping("/{id}/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findByBankAccountId(@PathVariable int id) {
        // Valida se a conta existe
        bankAccountService.findById(id);
        // Busca as transações através do serviço apropriado
        return transactionService.findByBankAccountId(id);
    }

    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findByBankAccountIdAndTransactionTypeId(@PathVariable int id,@PathVariable int transactionTypeId) {
        // Valida se a conta existe
        bankAccountService.findById(id);
        // Busca as transações através do serviço apropriado
        return transactionService.findByBankAccountIdAndTransactionTypeId(id, transactionTypeId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccount update(@PathVariable int id, @RequestBody BankAccount bankAccount) {
        return bankAccountService.update(id, bankAccount);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bankAccountService.delete(id);
    }
}