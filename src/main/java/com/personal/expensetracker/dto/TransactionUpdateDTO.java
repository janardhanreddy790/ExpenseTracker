package com.personal.expensetracker.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionUpdateDTO {
    private Long id;
    private LocalDate date;
    private String category;
    private String subcategory;
    private String item;
    private Double quantity;
    private String unit;
    private Double amount;
    private String currency;
    private String paymentMethod;
    private String vendor;
    private String owner;
    private String notes;
}
