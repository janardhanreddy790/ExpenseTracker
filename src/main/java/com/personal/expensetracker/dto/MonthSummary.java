package com.personal.expensetracker.dto;

public class MonthSummary {
    private final String month;
    private final Double total;

    public MonthSummary(String month, Double total) {
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
