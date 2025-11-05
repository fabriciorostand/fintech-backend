package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-types")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionTypeController {
    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionType register(@RequestBody TransactionType type) {
        return transactionTypeService.register(type);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionType findById(@PathVariable int id) {
        return transactionTypeService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionType> findAll() {
        return transactionTypeService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionType update(@PathVariable int id, @RequestBody TransactionType type) {
        return transactionTypeService.update(id, type);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transactionTypeService.delete(id);
    }
}