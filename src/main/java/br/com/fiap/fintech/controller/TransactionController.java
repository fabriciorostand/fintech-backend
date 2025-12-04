package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.transaction.TransactionRequest;
import br.com.fiap.fintech.dto.transaction.TransactionResponse;
import br.com.fiap.fintech.dto.transaction.UpdateTransactionRequest;
import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    // Attributes
    private final TransactionService transactionService;

    // Methods
    @PostMapping
    public ResponseEntity<TransactionResponse> register(@RequestBody @Valid TransactionRequest request) {
        Transaction transaction = transactionService.register(request);

        TransactionResponse response = new TransactionResponse(transaction);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable Long id) {
        Transaction found = transactionService.findById(id);

        TransactionResponse response = new TransactionResponse(found);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> findAll() {
        List<Transaction> found = transactionService.findAll();

        List<TransactionResponse> response = found.stream()
                .map(TransactionResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateTransactionRequest request) {
        Transaction transaction = transactionService.update(id, request);

        TransactionResponse response = new TransactionResponse(transaction);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}