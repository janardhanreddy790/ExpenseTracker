package com.personal.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthSummary {
    private String month; // e.g. "2025-09"
    private Double total;
}
