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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {
    // Attributes
    private final BranchService branchService;

    // Methods
    @PostMapping
    public ResponseEntity<BranchResponse> register(@RequestBody @Valid CreateBranchRequest request, UriComponentsBuilder uriBuilder) {
        Branch branch = branchService.register(request);

        var uri = uriBuilder.path("/api/branches/{id}").buildAndExpand(branch.getId()).toUri();

        BranchResponse response = new BranchResponse(branch);

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponse> findById(@PathVariable Long id) {
        Branch branch = branchService.findById(id);

        BranchResponse response = new BranchResponse(branch);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BranchResponse>> findAll() {
        List<Branch> branches = branchService.findAll();

        List<BranchResponse> response = branches.stream()
                .map(BranchResponse::new)
                .toList();

        return ResponseEntity.ok(response);
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