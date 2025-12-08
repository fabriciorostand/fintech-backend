package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.bank.BankResponse;
import br.com.fiap.fintech.dto.bank.CreateBankRequest;
import br.com.fiap.fintech.dto.bank.UpdateBankRequest;
import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.service.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {
    // Attributes
    private final BankService bankService;

    // Methods
    @PostMapping
    public ResponseEntity<BankResponse> register(@RequestBody @Valid CreateBankRequest request, UriComponentsBuilder uriBuilder) {
        Bank bank = bankService.register(request);

        var uri = uriBuilder.path("/api/banks/{id}").buildAndExpand(bank.getId()).toUri();

        BankResponse response = new BankResponse(bank);

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponse> findById(@PathVariable Long id) {
        Bank bank = bankService.findById(id);

        BankResponse response = new BankResponse(bank);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BankResponse>> findAll() {
        List<Bank> banks = bankService.findAll();

        List<BankResponse> response = banks.stream()
                .map(BankResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateBankRequest request) {
        Bank bank = bankService.update(id, request);

        BankResponse response = new BankResponse(bank);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bankService.delete(id);

        return ResponseEntity.noContent().build();
    }
}