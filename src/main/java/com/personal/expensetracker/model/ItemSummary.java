package com.personal.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemSummary {
    private String item;
    private Double total;
}
