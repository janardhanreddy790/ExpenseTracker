package com.personal.expensetracker.controller;

import com.personal.expensetracker.model.Transaction;
import com.personal.expensetracker.dto.TransactionUpdateDTO;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.data.domain.*;
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

    // ➕ Create
    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return repository.save(tx);
    }

    // 📄 Get All (old style, no pagination) - optional
    @GetMapping
    public List<Transaction> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    // 📄 Get with Pagination + Sorting
    @GetMapping("/paged")
    public Page<Transaction> findPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String vendor
    ) {
        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (keyword != null && !keyword.isEmpty()) {
            return repository.findByKeyword(keyword, pageable);
        } else if (category != null && !category.isEmpty()) {
            return repository.findByCategory(category, pageable);
        } else if (vendor != null && !vendor.isEmpty()) {
            return repository.findByVendor(vendor, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }


    // ✏️ Update single transaction
    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction tx) {
        Transaction existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));

        // Update editable fields
        existing.setDate(tx.getDate());
        existing.setCategory(tx.getCategory());
        existing.setSubcategory(tx.getSubcategory());
        existing.setItem(tx.getItem());
        existing.setQuantity(tx.getQuantity());
        existing.setUnit(tx.getUnit());
        existing.setAmount(tx.getAmount());
        existing.setCurrency(tx.getCurrency());
        existing.setPaymentMethod(tx.getPaymentMethod());
        existing.setVendor(tx.getVendor());
        existing.setOwner(tx.getOwner());
        existing.setNotes(tx.getNotes());

        return repository.save(existing);
    }

    // ❌ Delete single transaction
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // ❌ Bulk delete
    @DeleteMapping("/bulk")
    public void deleteBulk(@RequestBody List<Long> ids) {
        repository.deleteAllById(ids);
    }

    // ✏️ Bulk update
    @PutMapping("/bulk")
    public List<Transaction> bulkUpdate(@RequestBody List<TransactionUpdateDTO> updates) {
        return updates.stream().map(update -> {
            Transaction existing = repository.findById(update.getId())
                    .orElseThrow(() -> new RuntimeException("Transaction not found: " + update.getId()));

            // update only provided fields (null-safe)
            if (update.getDate() != null) existing.setDate(update.getDate());
            if (update.getCategory() != null) existing.setCategory(update.getCategory());
            if (update.getSubcategory() != null) existing.setSubcategory(update.getSubcategory());
            if (update.getItem() != null) existing.setItem(update.getItem());
            if (update.getQuantity() != null) existing.setQuantity(update.getQuantity());
            if (update.getUnit() != null) existing.setUnit(update.getUnit());
            if (update.getAmount() != null) existing.setAmount(update.getAmount());
            if (update.getCurrency() != null) existing.setCurrency(update.getCurrency());
            if (update.getPaymentMethod() != null) existing.setPaymentMethod(update.getPaymentMethod());
            if (update.getVendor() != null) existing.setVendor(update.getVendor());
            if (update.getOwner() != null) existing.setOwner(update.getOwner());
            if (update.getNotes() != null) existing.setNotes(update.getNotes());

            return repository.save(existing);
        }).toList();
    }


    // 📊 Summaries (still using Object[] until you switch to DTOs)
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

    // 🔎 Search API
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
