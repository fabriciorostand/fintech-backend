package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-types")
@RequiredArgsConstructor
public class TransactionTypeController {
    // Attributes
    private final TransactionTypeService transactionTypeService;

    // Methods
    @PostMapping
    public ResponseEntity<TransactionType> register(@RequestBody TransactionType transactionType) {
        TransactionType registered = transactionTypeService.register(transactionType);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionType> findById(@PathVariable int id) {
        TransactionType found = transactionTypeService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<TransactionType>> findAll() {
        List<TransactionType> found = transactionTypeService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionType> update(@PathVariable int id, @RequestBody TransactionType transactionType) {
        TransactionType updated = transactionTypeService.update(id, transactionType);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        transactionTypeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}