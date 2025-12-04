package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.transaction_type.CreateTTRequest;
import br.com.fiap.fintech.dto.transaction_type.TTResponse;
import br.com.fiap.fintech.dto.transaction_type.UpdateTTRequest;
import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.service.TransactionTypeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<TTResponse> register(@RequestBody @Valid CreateTTRequest request) {
        TransactionType transactionType = transactionTypeService.register(request);

        TTResponse response = new TTResponse(transactionType);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionType> findById(@PathVariable Long id) {
        TransactionType found = transactionTypeService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<TransactionType>> findAll() {
        List<TransactionType> found = transactionTypeService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TTResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateTTRequest request) {
        TransactionType transactionType = transactionTypeService.update(id, request);

        TTResponse response = new TTResponse(transactionType);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionTypeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}