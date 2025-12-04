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
        Optional<Branch> branch = branchRepository.findById(id);

        if (branch.isPresent()) {
            return branch.get();
        } else {
            throw new RuntimeException("Agência não encontrada!");
        }
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Transactional
    public Branch update(Long id, UpdateBranchRequest request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agência não encontrada"));

        branch.updateInfo(request);

        return branch;
    }

    public void delete(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);

        if (branch.isPresent()) {
            branchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: agência não encontrada!");
        }
    }
}