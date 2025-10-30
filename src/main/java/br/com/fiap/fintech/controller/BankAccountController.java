package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount register(@RequestBody BankAccount bankAccount) {
        return bankAccountService.register(bankAccount);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccount findById(@PathVariable int id) {
        return bankAccountService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccount update(@PathVariable int id, @RequestBody BankAccount bankAccount) {
        return bankAccountService.update(id, bankAccount);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bankAccountService.delete(id);
    }
}