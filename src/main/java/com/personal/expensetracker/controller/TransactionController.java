package com.personal.expensetracker.controller;

import com.personal.expensetracker.model.Transaction;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return repository.save(tx);
    }

    @GetMapping
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
