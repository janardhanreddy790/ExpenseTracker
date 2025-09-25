package com.personal.expensetracker.dto;

public class ItemSummary {
    private String item;
    private Double total;

    public ItemSummary(String item, Double total) {
        this.item = item;
        this.total = total;
    }

    public String getItem() {
        return item;
    }

    public Double getTotal() {
        return total;
    }
}
