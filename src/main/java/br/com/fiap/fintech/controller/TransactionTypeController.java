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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-types")
@RequiredArgsConstructor
public class TransactionTypeController {
    // Attributes
    private final TransactionTypeService transactionTypeService;

    // Methods
    @PostMapping
    public ResponseEntity<TTResponse> register(@RequestBody @Valid CreateTTRequest request, UriComponentsBuilder uriBuilder) {
        TransactionType transactionType = transactionTypeService.register(request);

        var uri = uriBuilder.path("/api/transaction-types/{id}").buildAndExpand(transactionType.getId()).toUri();

        TTResponse response = new TTResponse(transactionType);

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TTResponse> findById(@PathVariable Long id) {
        TransactionType transactionType = transactionTypeService.findById(id);

        TTResponse response = new TTResponse(transactionType);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TTResponse>> findAll() {
        List<TransactionType> transactionTypes = transactionTypeService.findAll();

        List<TTResponse> response = transactionTypes.stream()
                .map(TTResponse::new)
                .toList();

        return ResponseEntity.ok(response);
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