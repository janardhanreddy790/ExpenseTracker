package com.personal.expensetracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private LocalDateTime createdAt = LocalDateTime.now();
}
