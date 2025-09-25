package com.personal.expensetracker.dto;

public class MonthSummary {
    private String month;
    private Double total;  // ✅ use Double

    public MonthSummary(String month, Double total) {  // ✅ match query
        this.month = month;
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public Double getTotal() {
        return total;
    }
}
