package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.BankAccountResponse;
import br.com.fiap.fintech.dto.TransactionResponse;
import br.com.fiap.fintech.model.BankAccount;
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
    public ResponseEntity<BankAccountResponse> register(@RequestBody BankAccount bankAccount) {
        BankAccount registered = bankAccountService.register(bankAccount);

        BankAccountResponse response = new BankAccountResponse(registered);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponse> findById(@PathVariable int id) {
        BankAccount found = bankAccountService.findById(id);

        BankAccountResponse response = new BankAccountResponse(found);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionResponse>> findByBankAccountId(@PathVariable int id) {
        // Valida se a conta existe
        bankAccountService.findById(id);

        List<TransactionResponse> response = transactionService.findByBankAccountId(id).stream()
                .map(TransactionResponse::new)
                .toList();

        // Busca as transações através do service apropriado
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    public ResponseEntity<List<TransactionResponse>> findByBankAccountIdAndTransactionTypeId(@PathVariable int id,@PathVariable int transactionTypeId) {
        // Valida se a conta existe
        bankAccountService.findById(id);

        List<TransactionResponse> response = transactionService.findByBankAccountIdAndTransactionTypeId(id, transactionTypeId).stream()
                .map(TransactionResponse::new)
                .toList();

        // Busca as transações através do service apropriado
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponse>> findAll() {
        List<BankAccount> found = bankAccountService.findAll();

        List<BankAccountResponse> response = found.stream()
                .map(BankAccountResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccountResponse> update(@PathVariable int id, @RequestBody BankAccount bankAccount) {
        BankAccount updated = bankAccountService.update(id, bankAccount);

        BankAccountResponse response = new BankAccountResponse(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bankAccountService.delete(id);

        return ResponseEntity.noContent().build();
    }
}