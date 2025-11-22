package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.TransactionCategory;
import br.com.fiap.fintech.service.TransactionCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-categories")
public class TransactionCategoryController {
    private final TransactionCategoryService transactionCategoryService;

    // Constructors
    public TransactionCategoryController(TransactionCategoryService transactionCategoryService) {
        this.transactionCategoryService = transactionCategoryService;
    }

    @PostMapping
    public ResponseEntity<TransactionCategory> register(@RequestBody TransactionCategory category) {
        TransactionCategory registered = transactionCategoryService.register(category);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionCategory> findById(@PathVariable int id) {
        TransactionCategory found = transactionCategoryService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<TransactionCategory>> findAll() {
        List<TransactionCategory> found = transactionCategoryService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionCategory> update(@PathVariable int id, @RequestBody TransactionCategory category) {
        TransactionCategory updated = transactionCategoryService.update(id, category);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        transactionCategoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}