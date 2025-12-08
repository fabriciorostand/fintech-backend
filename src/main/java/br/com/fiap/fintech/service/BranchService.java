package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.branch.CreateBranchRequest;
import br.com.fiap.fintech.dto.branch.UpdateBranchRequest;
import br.com.fiap.fintech.model.Branch;
import br.com.fiap.fintech.repository.BranchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchService {
    // Attributes
    private final BranchRepository branchRepository;

    // Methods
    @Transactional
    public Branch register(CreateBranchRequest request) {
        Branch branch = new Branch(request);

        return branchRepository.save(branch);
    }

    public Branch findById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Transactional
    public Branch update(Long id, UpdateBranchRequest request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        branch.updateInfo(request);

        return branch;
    }

    @Transactional
    public void delete(Long id) {
        branchRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        branchRepository.deleteById(id);
    }
}