package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.transaction_category.CreateTCRequest;
import br.com.fiap.fintech.dto.transaction_category.TCResponse;
import br.com.fiap.fintech.dto.transaction_category.UpdateTCRequest;
import br.com.fiap.fintech.model.TransactionCategory;
import br.com.fiap.fintech.service.TransactionCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-categories")
@RequiredArgsConstructor
public class TransactionCategoryController {
    // Attributes
    private final TransactionCategoryService transactionCategoryService;

    // Methods
    @PostMapping
    public ResponseEntity<TCResponse> register(@RequestBody @Valid CreateTCRequest request) {
        TransactionCategory transactionCategory = transactionCategoryService.register(request);

        TCResponse response = new TCResponse(transactionCategory);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionCategory> findById(@PathVariable Long id) {
        TransactionCategory found = transactionCategoryService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<TransactionCategory>> findAll() {
        List<TransactionCategory> found = transactionCategoryService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TCResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateTCRequest request) {
        TransactionCategory transactionCategory = transactionCategoryService.update(id, request);

        TCResponse response = new TCResponse(transactionCategory);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionCategoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}