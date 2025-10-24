package com.personal.expensetracker.controller;

import com.personal.expensetracker.dto.MonthlyReportResponse;
import com.personal.expensetracker.service.MonthlyReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class MonthlyReportController {

    private final MonthlyReportService monthlyReportService;

    public MonthlyReportController(MonthlyReportService monthlyReportService) {
        this.monthlyReportService = monthlyReportService;
    }

    @GetMapping("/monthly")
    public String getMonthlyReport(Model model) {
        MonthlyReportResponse response = monthlyReportService.getMonthlyReport();
        model.addAttribute("summaries", response.getSummaries());
        model.addAttribute("total", response.getTotal());
        return "reports/monthly";
    }
}
