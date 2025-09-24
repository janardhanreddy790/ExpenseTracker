package com.personal.expensetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/reference-data")
public class ReferenceDataController {

    @GetMapping
    public Map<String, Object> getReferenceData() {
        Map<String, Object> data = new HashMap<>();

        Map<String, List<String>> categories = new LinkedHashMap<>();
        categories.put("Groceries", Arrays.asList("Dairy", "Vegetables", "Fruits", "Staples", "Snacks", "Drinks"));
        categories.put("Shopping", Arrays.asList("Clothes", "Electronics", "Household"));
        categories.put("Travel", Arrays.asList("Fuel", "Tickets", "Hotel"));
        categories.put("Hospital / Health", Arrays.asList("Pharmacy", "Consultation", "Tests"));
        categories.put("Bills & Utilities", Arrays.asList("Internet", "Electricity", "Mobile", "Rent"));
        categories.put("Entertainment", Arrays.asList("Subscriptions", "Dining", "Movies"));
        categories.put("Other", Arrays.asList("Miscellaneous"));

        Map<String, List<String>> itemsBySubcategory = new LinkedHashMap<>();
        itemsBySubcategory.put("Dairy", Arrays.asList("Milk", "Cheese", "Butter", "Curd"));
        itemsBySubcategory.put("Vegetables", Arrays.asList("Potato", "Tomato", "Onion", "Spinach"));
        itemsBySubcategory.put("Fruits", Arrays.asList("Apple", "Banana", "Orange"));
        itemsBySubcategory.put("Snacks", Arrays.asList("Chips", "Biscuits", "Chocolate"));
        itemsBySubcategory.put("Drinks", Arrays.asList("Juice", "Soda", "Water Bottle"));

        List<String> paymentMethods = Arrays.asList("Card", "Cash", "Bank Transfer", "Credit Card", "Online Wallet");
        List<String> units = Arrays.asList("pcs", "kg", "g", "l", "ml", "box", "pack");
        List<String> owners = Arrays.asList("Janardhan", "Sindhu", "Other");

        data.put("categories", categories);
        data.put("itemsBySubcategory", itemsBySubcategory);
        data.put("paymentMethods", paymentMethods);
        data.put("units", units);
        data.put("owners", owners);

        return data;
    }
}
