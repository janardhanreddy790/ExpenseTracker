package com.personal.expensetracker.dto;

public class VendorSummary {
    private String vendor;
    private Double total;

    public VendorSummary(String vendor, Double total) {
        this.vendor = vendor;
        this.total = total;
    }

    public String getVendor() {
        return vendor;
    }

    public Double getTotal() {
        return total;
    }
}
