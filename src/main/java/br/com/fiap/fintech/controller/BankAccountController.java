package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.bank_account.CreateBankAccountRequest;
import br.com.fiap.fintech.dto.bank_account.BankAccountResponse;
import br.com.fiap.fintech.dto.bank_account.UpdateBankAccountRequest;
import br.com.fiap.fintech.dto.transaction.TransactionResponse;
import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.service.BankAccountService;
import br.com.fiap.fintech.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<BankAccountResponse> register(@RequestBody @Valid CreateBankAccountRequest request) {
        BankAccount bankAccount = bankAccountService.register(request);

        BankAccountResponse response = new BankAccountResponse(bankAccount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponse> findById(@PathVariable Long id) {
        BankAccount found = bankAccountService.findById(id);

        BankAccountResponse response = new BankAccountResponse(found);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<Page<TransactionResponse>> findByBankAccountId(@PathVariable Long id, @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        // Valida se a conta existe
        bankAccountService.findById(id);

        Page<TransactionResponse> response = transactionService.findByBankAccountId(id, pageable).map(TransactionResponse::new);

        // Busca as transações através do service apropriado
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    public ResponseEntity<Page<TransactionResponse>> findByBankAccountIdAndTransactionTypeId(@PathVariable Long id,@PathVariable Long transactionTypeId, @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        // Valida se a conta existe
        bankAccountService.findById(id);

        Page<TransactionResponse> response = transactionService.findByBankAccountIdAndTransactionTypeId(id, transactionTypeId, pageable).map(TransactionResponse::new);

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
    public ResponseEntity<BankAccountResponse> update(@PathVariable Long id, @RequestBody UpdateBankAccountRequest request) {
        BankAccount bankAccount = bankAccountService.update(id, request);

        BankAccountResponse response = new BankAccountResponse(bankAccount);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bankAccountService.delete(id);

        return ResponseEntity.noContent().build();
    }
}