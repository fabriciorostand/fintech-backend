package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.service.BankAccountService;
import br.com.fiap.fintech.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
@RequiredArgsConstructor
public class BankAccountController {
    // Attributes
    private final BankAccountService bankAccountService;
    private final TransactionService transactionService;

    // Methods
    @PostMapping
    public ResponseEntity<BankAccount> register(@RequestBody BankAccount bankAccount) {
        BankAccount registered = bankAccountService.register(bankAccount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> findById(@PathVariable int id) {
        BankAccount found = bankAccountService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> findByBankAccountId(@PathVariable int id) {
        // Valida se a conta existe
        bankAccountService.findById(id);
        // Busca as transações através do service apropriado
        return ResponseEntity.ok(transactionService.findByBankAccountId(id));
    }

    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    public ResponseEntity<List<Transaction>> findByBankAccountIdAndTransactionTypeId(@PathVariable int id,@PathVariable int transactionTypeId) {
        // Valida se a conta existe
        bankAccountService.findById(id);
        // Busca as transações através do service apropriado
        return ResponseEntity.ok(transactionService.findByBankAccountIdAndTransactionTypeId(id, transactionTypeId));
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> findAll() {
        List<BankAccount> found = bankAccountService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> update(@PathVariable int id, @RequestBody BankAccount bankAccount) {
        BankAccount updated = bankAccountService.update(id, bankAccount);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bankAccountService.delete(id);

        return ResponseEntity.noContent().build();
    }
}