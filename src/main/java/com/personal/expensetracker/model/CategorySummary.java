package com.personal.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySummary {
    private String category;
    private Double total;
}

