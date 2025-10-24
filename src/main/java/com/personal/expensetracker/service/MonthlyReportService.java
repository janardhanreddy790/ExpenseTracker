package com.personal.expensetracker.service;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.dto.MonthlyReportResponse;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MonthlyReportService {

    private final TransactionRepository transactionRepository;

    public MonthlyReportService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<MonthSummary> getMonthlySummaries() {
        List<MonthSummary> summaries = transactionRepository.getSummaryByMonth();
        return summaries == null ? List.of() : List.copyOf(summaries);
    }

    public MonthlyReportResponse getMonthlyReport() {
        List<MonthSummary> summaries = getMonthlySummaries();
        double total = summaries.stream()
                .map(MonthSummary::getTotal)
                .filter(Objects::nonNull)
                .mapToDouble(Double::doubleValue)
                .sum();
        return new MonthlyReportResponse(summaries, total);
    }
}
