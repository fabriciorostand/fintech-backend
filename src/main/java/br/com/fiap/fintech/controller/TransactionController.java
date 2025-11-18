package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionController {
    private final TransactionService transactionService;

    // Constructors
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> register(@RequestBody Transaction transaction) {
        Transaction registered = transactionService.register(transaction);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable int id) {
        Transaction found = transactionService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        List<Transaction> found = transactionService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable int id, @RequestBody Transaction transaction) {
        Transaction updated = transactionService.update(id, transaction);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        transactionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}