package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Branch;
import br.com.fiap.fintech.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    private final BranchService branchService;

    // Constructors
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<Branch> register(@RequestBody Branch branch) {
        Branch registered = branchService.register(branch);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> findById(@PathVariable int id) {
        Branch found = branchService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> findAll() {
        List<Branch> found = branchService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Branch> update(@PathVariable int id, @RequestBody Branch branch) {
        Branch updated = branchService.update(id, branch);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        branchService.delete(id);

        return ResponseEntity.noContent().build();
    }
}