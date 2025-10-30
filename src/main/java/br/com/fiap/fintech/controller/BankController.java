package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Bank;
import br.com.fiap.fintech.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank register(@RequestBody Bank bank) {
        return bankService.register(bank);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bank findById(@PathVariable int id) {
        return bankService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bank> findAll() {
        return bankService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bank update(@PathVariable int id, @RequestBody Bank bank) {
        return bankService.update(id, bank);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bankService.delete(id);
    }
}