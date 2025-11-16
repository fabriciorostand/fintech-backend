package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.TransactionCategory;
import br.com.fiap.fintech.service.TransactionCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-categories")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionCategoryController {
    private final TransactionCategoryService transactionCategoryService;

    // Constructors
    public TransactionCategoryController(TransactionCategoryService transactionCategoryService) {
        this.transactionCategoryService = transactionCategoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionCategory register(@RequestBody TransactionCategory category) {
        return transactionCategoryService.register(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionCategory findById(@PathVariable int id) {
        return transactionCategoryService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionCategory> findAll() {
        return transactionCategoryService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionCategory update(@PathVariable int id, @RequestBody TransactionCategory category) {
        return transactionCategoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transactionCategoryService.delete(id);
    }
}