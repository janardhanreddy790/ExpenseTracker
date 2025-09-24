package com.personal.expensetracker.controller;

import com.personal.expensetracker.model.Transaction;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/summary/by-category")
    public List<Object[]> sumByCategory() {
        return repository.findSumByCategory();
    }

    @GetMapping("/summary/by-month")
    public List<Object[]> sumByMonth() {
        return repository.findSumByMonth();
    }

    @GetMapping("/summary/top-items")
    public List<Object[]> topItems() {
        return repository.findTopItems();
    }

    @GetMapping("/summary/top-vendors")
    public List<Object[]> topVendors() {
        return repository.findTopVendors();
    }

    @GetMapping("/search")
    public List<Transaction> search(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) String category
    ) {
        LocalDate start = (startDate != null) ? LocalDate.parse(startDate) : LocalDate.of(1900, 1, 1);
        LocalDate end = (endDate != null) ? LocalDate.parse(endDate) : LocalDate.now();

        if (owner != null && category != null) {
            return repository.findByDateBetweenAndOwnerAndCategory(start, end, owner, category);
        } else if (owner != null) {
            return repository.findByDateBetweenAndOwner(start, end, owner);
        } else if (category != null) {
            return repository.findByDateBetweenAndCategory(start, end, category);
        } else {
            return repository.findByDateBetween(start, end);
        }
    }


}
