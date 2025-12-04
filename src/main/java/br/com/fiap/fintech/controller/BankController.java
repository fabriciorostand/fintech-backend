package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.service.BankService;
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
    public ResponseEntity<Bank> register(@RequestBody Bank bank) {
        Bank registered = bankService.register(bank);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
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
    public ResponseEntity<Bank> update(@PathVariable Long id, @RequestBody Bank bank) {
        Bank updated = bankService.update(id, bank);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bankService.delete(id);

        return ResponseEntity.noContent().build();
    }
}