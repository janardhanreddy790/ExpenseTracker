package com.personal.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendorSummary {
    private String vendor;
    private Double total;
}
