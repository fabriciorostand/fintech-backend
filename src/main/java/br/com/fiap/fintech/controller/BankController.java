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

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {
    // Attributes
    private final BankService bankService;

    // Methods
    @PostMapping
    public ResponseEntity<BankResponse> register(@RequestBody @Valid CreateBankRequest request) {
        Bank bank = bankService.register(request);

        BankResponse response = new BankResponse(bank);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> findById(@PathVariable Long id) {
        Bank found = bankService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<Bank>> findAll() {
        List<Bank> found = bankService.findAll();

        return ResponseEntity.ok(found);
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