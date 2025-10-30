package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Branch;
import br.com.fiap.fintech.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Branch register(@RequestBody Branch branch) {
        return branchService.register(branch);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Branch findById(@PathVariable int id) {
        return branchService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Branch> findAll() {
        return branchService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Branch update(@PathVariable int id, @RequestBody Branch branch) {
        return branchService.update(id, branch);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        branchService.delete(id);
    }
}