package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.transaction_category.CreateTCRequest;
import br.com.fiap.fintech.dto.transaction_category.UpdateTCRequest;
import br.com.fiap.fintech.model.TransactionCategory;
import br.com.fiap.fintech.repository.TransactionCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionCategoryService {
    // Attributes
    private final TransactionCategoryRepository transactionCategoryRepository;

    // Methods
    @Transactional
    public TransactionCategory register(CreateTCRequest request) {
        TransactionCategory transactionCategory = new TransactionCategory(request);

        return transactionCategoryRepository.save(transactionCategory);
    }

    public TransactionCategory findById(Long id) {
        Optional<TransactionCategory> category = transactionCategoryRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Categoria de transação não encontrada!");
        }
    }

    public List<TransactionCategory> findAll() {
        return transactionCategoryRepository.findAll();
    }

    @Transactional
    public TransactionCategory update(Long id, UpdateTCRequest request) {
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria de lançamento não encontrada"));

        transactionCategory.updateInfo(request);

        return transactionCategory;
    }

    public void delete(Long id) {
        Optional<TransactionCategory> category = transactionCategoryRepository.findById(id);

        if (category.isPresent()) {
            transactionCategoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: categoria de transação não encontrada!");
        }
    }
}