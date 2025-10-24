package com.personal.expensetracker.dto;

import java.util.List;

public class MonthlyReportResponse {

    private final List<MonthSummary> summaries;
    private final double total;

    public MonthlyReportResponse(List<MonthSummary> summaries, double total) {
        this.summaries = summaries;
        this.total = total;
    }

    public List<MonthSummary> getSummaries() {
        return summaries;
    }

    public double getTotal() {
        return total;
    }
}
