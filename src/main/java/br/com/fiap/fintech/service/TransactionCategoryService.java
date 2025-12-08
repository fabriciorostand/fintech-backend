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
        return transactionCategoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<TransactionCategory> findAll() {
        return transactionCategoryRepository.findAll();
    }

    @Transactional
    public TransactionCategory update(Long id, UpdateTCRequest request) {
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        transactionCategory.updateInfo(request);

        return transactionCategory;
    }

    @Transactional
    public void delete(Long id) {
        transactionCategoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        transactionCategoryRepository.deleteById(id);
    }
}