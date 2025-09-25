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

        // ---------------------------
        // Categories & Subcategories
        // ---------------------------
        Map<String, List<String>> categories = new LinkedHashMap<>();
        categories.put("Groceries & Essentials", Arrays.asList(
                "Dairy", "Vegetables", "Fruits", "Staples & Pulses", "Bakery",
                "Meat & Seafood", "Beverages", "Frozen Foods", "Snacks & Confectionery",
                "Spices & Condiments", "Organic / Health Food"
        ));
        categories.put("Household & Utilities", Arrays.asList(
                "Cleaning Supplies", "Kitchenware", "Home Maintenance", "Appliances",
                "Furniture", "Electricity / Gas / Water", "Internet / Broadband", "Waste & Recycling"
        ));
        categories.put("Shopping & Lifestyle", Arrays.asList(
                "Clothing & Footwear", "Accessories & Jewellery", "Electronics & Gadgets",
                "Home Decor", "Beauty & Personal Care", "Sports & Fitness Equipment",
                "Toys & Kids Items", "Online Marketplaces"
        ));
        categories.put("Travel & Transport", Arrays.asList(
                "Fuel", "Taxi & Ride-sharing", "Public Transport", "Flights", "Train",
                "Bus", "Hotel / Accommodation", "Car / Bike Service", "Parking", "Tolls & Road Tax"
        ));
        categories.put("Health & Medical", Arrays.asList(
                "Pharmacy", "Doctor Consultation", "Diagnostic Tests", "Hospital / Surgery",
                "Dental Care", "Optical / Eye Care", "Health Insurance"
        ));
        categories.put("Bills & Subscriptions", Arrays.asList(
                "Mobile", "TV & Streaming", "Internet", "Software & Cloud",
                "Gym & Clubs", "Insurance Premiums", "Magazine / Newspaper"
        ));
        categories.put("Education & Learning", Arrays.asList(
                "School Fees", "College Fees", "Courses & Certifications",
                "Books & Study Material", "Stationery", "Online Learning Platforms"
        ));
        categories.put("Entertainment & Leisure", Arrays.asList(
                "Dining Out", "Cafes / Coffee", "Movies / Theater", "Concerts & Events",
                "Amusement Parks", "Video Games / Esports", "Travel Experiences"
        ));
        categories.put("Financial & Services", Arrays.asList(
                "Bank Fees", "Credit Card Payments", "Brokerage / Investments",
                "Tax Payments", "Legal / Professional Services", "Freelance / Contractor Payments"
        ));
        categories.put("Gifts, Festivals & Social", Arrays.asList(
                "Festivals", "Birthdays", "Weddings", "Donations", "Gifts", "Religious Offerings"
        ));
        categories.put("Other / Miscellaneous", Arrays.asList(
                "Uncategorized", "Pet Care", "Travel Insurance", "Unexpected Expenses"
        ));

        // ---------------------------
        // Items by Subcategory
        // ---------------------------
        Map<String, List<String>> itemsBySubcategory = new LinkedHashMap<>();

        // Groceries
        itemsBySubcategory.put("Dairy", Arrays.asList("Milk", "Cheese", "Yogurt", "Butter", "Paneer", "Cream", "Buttermilk"));
        itemsBySubcategory.put("Vegetables", Arrays.asList("Potato", "Tomato", "Onion", "Carrot", "Spinach", "Broccoli", "Cabbage", "Capsicum"));
        itemsBySubcategory.put("Fruits", Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes", "Berries", "Papaya"));
        itemsBySubcategory.put("Staples & Pulses", Arrays.asList("Rice", "Wheat Flour", "Lentils", "Pasta", "Cooking Oil", "Sugar", "Salt", "Poha", "Semolina"));
        itemsBySubcategory.put("Bakery", Arrays.asList("Bread", "Croissant", "Cake", "Muffin", "Buns", "Donuts"));
        itemsBySubcategory.put("Meat & Seafood", Arrays.asList("Chicken", "Mutton", "Fish", "Shrimp", "Pork", "Eggs"));
        itemsBySubcategory.put("Beverages", Arrays.asList("Juice", "Soda", "Energy Drink", "Beer", "Wine", "Whiskey", "Tea", "Coffee"));
        itemsBySubcategory.put("Frozen Foods", Arrays.asList("Ice Cream", "Frozen Vegetables", "Frozen Pizza", "Frozen Meat"));
        itemsBySubcategory.put("Snacks & Confectionery", Arrays.asList("Chips", "Chocolate", "Cookies", "Nuts", "Namkeen", "Chikki"));
        itemsBySubcategory.put("Spices & Condiments", Arrays.asList("Salt", "Pepper", "Turmeric", "Chilli Powder", "Masala Mix", "Sauces", "Pickles"));
        itemsBySubcategory.put("Organic / Health Food", Arrays.asList("Organic Vegetables", "Protein Powder", "Millets", "Gluten Free Bread"));

        // Household
        itemsBySubcategory.put("Cleaning Supplies", Arrays.asList("Detergent", "Dishwash Liquid", "Floor Cleaner", "Toilet Cleaner", "Mop", "Dustbin Bags"));
        itemsBySubcategory.put("Kitchenware", Arrays.asList("Pots & Pans", "Utensils", "Cutlery", "Storage Containers"));
        itemsBySubcategory.put("Home Maintenance", Arrays.asList("Plumbing Repair", "Electrical Repair", "Carpentry", "Painting"));
        itemsBySubcategory.put("Appliances", Arrays.asList("Fridge", "Washing Machine", "Dryer", "Microwave"));
        itemsBySubcategory.put("Furniture", Arrays.asList("Table", "Chair", "Bed", "Mattress", "Sofa"));

        // Shopping
        itemsBySubcategory.put("Clothing & Footwear", Arrays.asList("Shirt", "Trousers", "Dress", "Saree", "Kurta", "Shoes", "Sandals", "Jacket"));
        itemsBySubcategory.put("Accessories & Jewellery", Arrays.asList("Watch", "Necklace", "Bracelet", "Handbag"));
        itemsBySubcategory.put("Electronics & Gadgets", Arrays.asList("Mobile", "Laptop", "Tablet", "TV", "Headphones", "Smartwatch"));
        itemsBySubcategory.put("Home Decor", Arrays.asList("Lamp", "Curtains", "Cushion", "Carpet"));
        itemsBySubcategory.put("Beauty & Personal Care", Arrays.asList("Shampoo", "Soap", "Face Wash", "Toothpaste", "Deodorant", "Cosmetics"));
        itemsBySubcategory.put("Sports & Fitness Equipment", Arrays.asList("Dumbbells", "Yoga Mat", "Cycle", "Treadmill"));
        itemsBySubcategory.put("Toys & Kids Items", Arrays.asList("Teddy Bear", "Building Blocks", "Remote Car"));
        itemsBySubcategory.put("Online Marketplaces", Arrays.asList("Amazon", "Flipkart", "Myntra", "Otto", "Zalando", "eBay"));

        // Travel
        itemsBySubcategory.put("Fuel", Arrays.asList("Petrol", "Diesel", "CNG", "EV Charging"));
        itemsBySubcategory.put("Taxi & Ride-sharing", Arrays.asList("Uber", "Ola", "Bolt", "FreeNow"));
        itemsBySubcategory.put("Public Transport", Arrays.asList("Bus Ticket", "Metro Pass", "Tram Ticket"));
        itemsBySubcategory.put("Flights", Arrays.asList("One-Way Ticket", "Round Trip Ticket"));
        itemsBySubcategory.put("Train", Arrays.asList("Regional Ticket", "ICE Ticket", "Sleeper Ticket"));
        itemsBySubcategory.put("Bus", Arrays.asList("AC Bus Ticket", "Non AC Bus Ticket"));
        itemsBySubcategory.put("Hotel / Accommodation", Arrays.asList("Room Rent", "Breakfast Buffet", "Service Charge"));
        itemsBySubcategory.put("Car / Bike Service", Arrays.asList("Oil Change", "Tyre Replacement", "Annual Service"));
        itemsBySubcategory.put("Parking", Arrays.asList("Street Parking", "Mall Parking"));
        itemsBySubcategory.put("Tolls & Road Tax", Arrays.asList("Autobahn Toll", "Highway Toll"));

        // Health
        itemsBySubcategory.put("Pharmacy", Arrays.asList("Paracetamol", "Cough Syrup", "Antibiotics", "Ayurvedic Medicine"));
        itemsBySubcategory.put("Doctor Consultation", Arrays.asList("General Physician", "Dentist", "Gynecologist"));
        itemsBySubcategory.put("Diagnostic Tests", Arrays.asList("Blood Test", "X-Ray", "MRI", "Ultrasound"));
        itemsBySubcategory.put("Hospital / Surgery", Arrays.asList("Admission Fee", "Operation Fee", "Emergency Fee"));
        itemsBySubcategory.put("Dental Care", Arrays.asList("Cleaning", "Filling", "Root Canal"));
        itemsBySubcategory.put("Optical / Eye Care", Arrays.asList("Eye Test", "Glasses", "Contact Lens"));

        // Bills
        itemsBySubcategory.put("Mobile", Arrays.asList("Prepaid Recharge", "Postpaid Bill"));
        itemsBySubcategory.put("TV & Streaming", Arrays.asList("Netflix", "Amazon Prime", "Disney+", "Sony Liv", "Hotstar"));
        itemsBySubcategory.put("Internet", Arrays.asList("DSL Bill", "Fiber Optic Bill"));
        itemsBySubcategory.put("Software & Cloud", Arrays.asList("Microsoft 365", "Google Workspace", "Dropbox", "Antivirus"));
        itemsBySubcategory.put("Gym & Clubs", Arrays.asList("Monthly Fee", "Yoga Class", "Sports Club"));
        itemsBySubcategory.put("Insurance Premiums", Arrays.asList("Health Insurance", "Life Insurance", "Car Insurance"));

        // Education
        itemsBySubcategory.put("School Fees", Arrays.asList("Primary School", "High School"));
        itemsBySubcategory.put("College Fees", Arrays.asList("Semester Fee", "Exam Fee"));
        itemsBySubcategory.put("Courses & Certifications", Arrays.asList("Udemy", "Coursera", "Skillshare"));
        itemsBySubcategory.put("Books & Study Material", Arrays.asList("Textbook", "Reference Book"));
        itemsBySubcategory.put("Stationery", Arrays.asList("Pen", "Notebook", "Printer Ink"));

        // Entertainment
        itemsBySubcategory.put("Dining Out", Arrays.asList("Restaurant Meal", "Street Food", "Fine Dining"));
        itemsBySubcategory.put("Cafes / Coffee", Arrays.asList("Coffee", "Pastry", "Sandwich"));
        itemsBySubcategory.put("Movies / Theater", Arrays.asList("Movie Ticket", "Theater Ticket"));
        itemsBySubcategory.put("Concerts & Events", Arrays.asList("Concert Ticket", "Sports Event", "Exhibition"));
        itemsBySubcategory.put("Amusement Parks", Arrays.asList("Theme Park Ticket", "Ride Pass"));
        itemsBySubcategory.put("Video Games / Esports", Arrays.asList("PlayStation Game", "Xbox Game", "Esports Entry Fee"));
        itemsBySubcategory.put("Travel Experiences", Arrays.asList("City Tour", "Museum Entry", "Adventure Sports"));

        // Financial
        itemsBySubcategory.put("Bank Fees", Arrays.asList("ATM Fee", "Account Maintenance"));
        itemsBySubcategory.put("Credit Card Payments", Arrays.asList("Visa", "Mastercard", "Amex"));
        itemsBySubcategory.put("Brokerage / Investments", Arrays.asList("Stock Brokerage Fee", "Mutual Fund Purchase"));
        itemsBySubcategory.put("Tax Payments", Arrays.asList("Income Tax", "Property Tax", "GST / VAT"));
        itemsBySubcategory.put("Legal / Professional Services", Arrays.asList("Lawyer Fee", "Consulting Fee"));

        // Gifts & Social
        itemsBySubcategory.put("Festivals", Arrays.asList("Diwali Shopping", "Christmas Tree", "Eid Food", "Holi Colors"));
        itemsBySubcategory.put("Birthdays", Arrays.asList("Cake", "Gift"));
        itemsBySubcategory.put("Weddings", Arrays.asList("Saree", "Sherwani", "Wedding Gift"));
        itemsBySubcategory.put("Donations", Arrays.asList("Temple Donation", "Church Donation", "NGO"));
        itemsBySubcategory.put("Gifts", Arrays.asList("Gift Card", "Perfume", "Flower Bouquet"));

        // Other
        itemsBySubcategory.put("Pet Care", Arrays.asList("Pet Food", "Veterinary Visit", "Grooming"));
        itemsBySubcategory.put("Travel Insurance", Arrays.asList("Short Trip Insurance", "Annual Plan"));
        itemsBySubcategory.put("Unexpected Expenses", Arrays.asList("Penalty", "Late Fee", "Emergency Buy"));

        // ---------------------------
        // Payment Methods, Units, Owners
        // ---------------------------
        List<String> paymentMethods = Arrays.asList(
                "Cash", "Debit Card", "Credit Card", "Bank Transfer",
                "UPI", "Mobile Wallet (Paytm, PhonePe, GPay, Apple Pay)", "Netbanking"
        );

        List<String> units = Arrays.asList(
                "pcs", "kg", "g", "l", "ml", "box", "pack", "dozen", "bottle", "pair", "hour", "month"
        );

        List<String> owners = Arrays.asList("Janardhan", "Sindhu", "Family", "Other");

        // ---------------------------
        // Final payload
        // ---------------------------
        data.put("categories", categories);
        data.put("itemsBySubcategory", itemsBySubcategory);
        data.put("paymentMethods", paymentMethods);
        data.put("units", units);
        data.put("owners", owners);

        return data;
    }
}
