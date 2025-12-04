package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.branch.CreateBranchRequest;
import br.com.fiap.fintech.dto.branch.BranchResponse;
import br.com.fiap.fintech.dto.branch.UpdateBranchRequest;
import br.com.fiap.fintech.model.Branch;
import br.com.fiap.fintech.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {
    // Attributes
    private final BranchService branchService;

    // Methods
    @PostMapping
    public ResponseEntity<BranchResponse> register(@RequestBody @Valid CreateBranchRequest request) {
        Branch branch = branchService.register(request);

        BranchResponse response = new BranchResponse(branch);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> findById(@PathVariable Long id) {
        Branch found = branchService.findById(id);

        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> findAll() {
        List<Branch> found = branchService.findAll();

        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponse> update(@PathVariable Long id, @RequestBody UpdateBranchRequest request) {
        Branch branch = branchService.update(id, request);

        BranchResponse response = new BranchResponse(branch);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        branchService.delete(id);

        return ResponseEntity.noContent().build();
    }
}