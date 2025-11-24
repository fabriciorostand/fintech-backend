package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Branch;
import br.com.fiap.fintech.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchService {
    // Attributes
    private final BranchRepository branchRepository;

    // Methods
    public Branch register(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch findById(int id) {
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

    public Branch update(int id, Branch branch) {
        Optional<Branch> existent = branchRepository.findById(id);

        if (existent.isPresent()) {
            return branchRepository.save(branch);
        } else {
            throw new RuntimeException("Erro ao atualizar: agência não encontrada!");
        }
    }

    public void delete(int id) {
        Optional<Branch> branch = branchRepository.findById(id);

        if (branch.isPresent()) {
            branchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: agência não encontrada!");
        }
    }
}