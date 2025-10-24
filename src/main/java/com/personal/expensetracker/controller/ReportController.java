package com.personal.expensetracker.controller;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final TransactionRepository transactionRepository;

    public ReportController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/monthly")
    public String monthlyReport(Model model) {
        List<MonthSummary> summaries = transactionRepository.getSummaryByMonth();
        model.addAttribute("summaries", summaries);
        return "reports/monthly";
    }
}
