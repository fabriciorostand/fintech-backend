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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-categories")
@RequiredArgsConstructor
public class TransactionCategoryController {
    // Attributes
    private final TransactionCategoryService transactionCategoryService;

    // Methods
    @PostMapping
    public ResponseEntity<TCResponse> register(@RequestBody @Valid CreateTCRequest request, UriComponentsBuilder uriBuilder) {
        TransactionCategory transactionCategory = transactionCategoryService.register(request);

        var uri = uriBuilder.path("/api/transaction-categories/{id}").buildAndExpand(transactionCategory.getId()).toUri();

        TCResponse response = new TCResponse(transactionCategory);

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TCResponse> findById(@PathVariable Long id) {
        TransactionCategory transactionCategory = transactionCategoryService.findById(id);

        TCResponse response = new TCResponse(transactionCategory);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TCResponse>> findAll() {
        List<TransactionCategory> transactionCategories = transactionCategoryService.findAll();

        List<TCResponse> response = transactionCategories.stream()
                .map(TCResponse::new)
                .toList();

        return ResponseEntity.ok(response);
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