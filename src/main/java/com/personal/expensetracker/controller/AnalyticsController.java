package com.personal.expensetracker.controller;

import com.personal.expensetracker.dto.CategorySummary;
import com.personal.expensetracker.dto.ItemSummary;
import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.dto.MonthlyReportResponse;
import com.personal.expensetracker.dto.VendorSummary;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final TransactionRepository transactionRepository;

    public AnalyticsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/categories")
    public List<CategorySummary> getByCategory() {
        return transactionRepository.getSummaryByCategory();
    }

    @GetMapping("/months")
    public List<MonthSummary> getByMonth() {
        return transactionRepository.getSummaryByMonth();
    }

    @GetMapping("/reports/monthly")
    public MonthlyReportResponse getMonthlyReport() {
        List<MonthSummary> summaries = transactionRepository.getSummaryByMonth();
        double total = summaries.stream()
                .map(MonthSummary::getTotal)
                .filter(Objects::nonNull)
                .mapToDouble(Double::doubleValue)
                .sum();
        return new MonthlyReportResponse(summaries, total);
    }

    @GetMapping("/vendors")
    public List<VendorSummary> getTopVendors() {
        return transactionRepository.getTopVendors();
    }

    @GetMapping("/items")
    public List<ItemSummary> getTopItems() {
        return transactionRepository.getTopItems();
    }
}
