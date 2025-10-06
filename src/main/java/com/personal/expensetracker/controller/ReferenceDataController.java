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
                "Spices & Condiments", "Organic / Health Food", "Other"
        ));
        categories.put("Household & Utilities", Arrays.asList(
                "Cleaning Supplies", "Kitchenware", "Home Maintenance", "Appliances",
                "Furniture", "Electricity / Gas / Water", "Internet / Broadband", "Waste & Recycling", "Other"
        ));
        categories.put("Shopping & Lifestyle", Arrays.asList(
                "Clothing & Footwear", "Accessories & Jewellery", "Electronics & Gadgets",
                "Home Decor", "Beauty & Personal Care", "Sports & Fitness Equipment",
                "Toys & Kids Items", "Online Marketplaces", "Other"
        ));
        categories.put("Travel & Transport", Arrays.asList(
                "Fuel", "Taxi & Ride-sharing", "Public Transport", "Flights", "Train",
                "Bus", "Hotel / Accommodation", "Car / Bike Service", "Parking", "Tolls & Road Tax", "Trips", "Other"
        ));
        categories.put("Health & Medical", Arrays.asList(
                "Pharmacy", "Doctor Consultation", "Diagnostic Tests", "Hospital / Surgery",
                "Dental Care", "Optical / Eye Care", "Health Insurance", "Other"
        ));
        categories.put("Bills & Subscriptions", Arrays.asList(
                "Mobile", "TV & Streaming", "Internet", "Software & Cloud",
                "Gym & Clubs", "Insurance Premiums", "Magazine / Newspaper", "Other"
        ));
        categories.put("Education & Learning", Arrays.asList(
                "School Fees", "College Fees", "Courses & Certifications",
                "Books & Study Material", "Stationery", "Online Learning Platforms", "Other"
        ));
        categories.put("Entertainment & Leisure", Arrays.asList(
                "Dining Out", "Cafes / Coffee", "Movies / Theater", "Concerts & Events",
                "Amusement Parks", "Video Games / Esports", "Travel Experiences", "Other"
        ));
        categories.put("Financial & Services", Arrays.asList(
                "Bank Fees", "Credit Card Payments", "Brokerage / Investments",
                "Tax Payments", "Legal / Professional Services", "Freelance / Contractor Payments", "Other"
        ));
        categories.put("Gifts, Festivals & Social", Arrays.asList(
                "Festivals", "Birthdays", "Weddings", "Donations", "Gifts", "Religious Offerings", "Other"
        ));
        categories.put("Loans", Arrays.asList(
                "Loan", "Other"
        ));
        categories.put("Recurrant Payment", Arrays.asList(
                "Rent", "Chits", "Other"
        ));
        categories.put("Subscriptions", Arrays.asList(
                "Monthly", "Yearly", "Other"
        ));
        categories.put("Other / Miscellaneous", Arrays.asList(
                "Uncategorized", "Pet Care", "Travel Insurance", "Unexpected Expenses", "Other"
        ));

        // ---------------------------
        // Items by Subcategory
        // ---------------------------
        Map<String, List<String>> itemsBySubcategory = new LinkedHashMap<>();

        // Groceries
        itemsBySubcategory.put("Dairy", Arrays.asList("Milk", "Cheese", "Yogurt", "Butter", "Paneer", "Cream", "Buttermilk", "other"));
        itemsBySubcategory.put("Vegetables", Arrays.asList("Potato", "Tomato", "Onion", "Carrot", "Spinach", "Broccoli", "Cabbage",
                "Capsicum", "GreenChilli", "Gongura", "BottleGuard", "BeetRoot", "kohl", "Capsicum", "Moringa/Drumstick Leaves",
                "Drumsticks", "GreenLeaves / Karivepaku", "Koriander", "Minz / Podina", "Methi", "Busch Bohnen", "Beans", "Zitronen/Lemon",
                "Gurken/Cucumber","Oakra/Bendi", "ChikkuduKayalu", "other"));
        itemsBySubcategory.put("Fruits", Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes", "Berries", "Papaya",
                "GartenApfel / Danimma ", "BlueBerries", "StrawBerries", "Birne", "Guava", "Avacado", "other"));
        itemsBySubcategory.put("Staples & Pulses", Arrays.asList("Rice","Idly Rice", "Dosa Rice", "Sona masoori rice","Maggi",
                "Wheat Flour", "Lentils", "Pasta", "Cooking Oil", "Sugar", "Salt", "Poha", "Semolina", "Upma Rava", "Instant Upma rava",
                "Urad Daal", "Channa Daal", "Toor Daal", "Whole Jeera / Cumin Seeds", "Mustard Seeds", "Red Chillies", "Chilli Powder",
                "Garam Masala", "Chicken Masala", "Mutton Masala", "Daniya Powder", "Panipuri Masala", "Biryani Masala", "Hirse", "other"));
        itemsBySubcategory.put("Bakery", Arrays.asList("Bread", "Croissant", "Cake", "Muffin", "Buns", "Donuts", "LaugenEcke",
                "Bretzel", "Vollkorn Sandwhich", "Sandwhich Bread", "Baguatte", "Spinat Roll", "Cheese Roll", "other"));
        itemsBySubcategory.put("Meat & Seafood", Arrays.asList("Chicken", "Mutton", "Fish", "Shrimp", "Pork", "Eggs", "other"));
        itemsBySubcategory.put("Beverages", Arrays.asList("Juice", "Soda", "Energy Drink", "Beer", "Wine", "Whiskey", "Tea", "Coffee",
                "CocaCola", "other"));
        itemsBySubcategory.put("Frozen Foods", Arrays.asList("Ice Cream", "Frozen Vegetables", "Frozen Pizza", "Frozen Meat", "GreenPeas",
                "ChickPeas", "Chicken Nuggents", "FrozenSamosa", "other"));
        itemsBySubcategory.put("Snacks & Confectionery", Arrays.asList("Chips", "Chocolate", "Cookies", "Nuts", "Namkeen", "Chikki", "other"));
        itemsBySubcategory.put("Spices & Condiments", Arrays.asList("Salt", "Pepper", "Turmeric", "Chilli Powder", "Masala Mix", "Sauces",
                "Pickles", "other"));
        itemsBySubcategory.put("Organic / Health Food", Arrays.asList("Organic Vegetables", "Protein Powder", "Millets", "Gluten Free Bread",
                "other"));

        // Household
        itemsBySubcategory.put("Cleaning Supplies", Arrays.asList("Detergent", "Dishwash Liquid", "Floor Cleaner", "Toilet Cleaner", "Mop",
                "Dustbin Bags", "Gas Stove cleaner", "Dishwasher Tablets", "Dishwasher Salt", "other"));
        itemsBySubcategory.put("Kitchenware", Arrays.asList("Pots & Pans", "Utensils", "Cutlery", "Storage Containers", "other"));
        itemsBySubcategory.put("Home Maintenance", Arrays.asList("Plumbing Repair", "Electrical Repair", "Carpentry", "Painting", "other"));
        itemsBySubcategory.put("Appliances", Arrays.asList("Fridge", "Washing Machine", "Dryer", "Microwave", "other"));
        itemsBySubcategory.put("Furniture", Arrays.asList("Table", "Chair", "Bed", "Mattress", "Sofa", "other"));

        // Shopping
        itemsBySubcategory.put("Clothing & Footwear", Arrays.asList("Shirt", "Trousers", "Dress", "Saree", "Kurta", "Shoes", "Sandals",
                "Jacket", "other"));
        itemsBySubcategory.put("Accessories & Jewellery", Arrays.asList("Watch", "Necklace", "Bracelet", "Handbag", "other"));
        itemsBySubcategory.put("Electronics & Gadgets", Arrays.asList("Mobile", "Laptop", "Tablet", "TV", "Headphones", "Smartwatch", "other"));
        itemsBySubcategory.put("Home Decor", Arrays.asList("Lamp", "Curtains", "Cushion", "Carpet", "other"));
        itemsBySubcategory.put("Beauty & Personal Care", Arrays.asList("Shampoo", "Soap", "Face Wash", "Toothpaste", "Deodorant",
                "Cosmetics", "Dusche gel", "other"));
        itemsBySubcategory.put("Sports & Fitness Equipment", Arrays.asList("Dumbbells", "Yoga Mat", "Cycle", "Treadmill", "other"));
        itemsBySubcategory.put("Toys & Kids Items", Arrays.asList("Teddy Bear", "Building Blocks", "Remote Car", "other"));
        itemsBySubcategory.put("Online Marketplaces", Arrays.asList("Amazon", "Flipkart", "Myntra", "Otto", "Zalando", "eBay", "other"));

        // Travel
        itemsBySubcategory.put("Fuel", Arrays.asList("Petrol", "Diesel", "CNG", "EV Charging", "other"));
        itemsBySubcategory.put("Taxi & Ride-sharing", Arrays.asList("Uber", "Ola", "Bolt", "FreeNow", "other"));
        itemsBySubcategory.put("Public Transport", Arrays.asList("Bus Ticket", "Metro Pass", "Tram Ticket", "other"));
        itemsBySubcategory.put("Flights", Arrays.asList("One-Way Ticket", "Round Trip Ticket", "other"));
        itemsBySubcategory.put("Train", Arrays.asList("Regional Ticket", "ICE Ticket", "Sleeper Ticket", "other"));
        itemsBySubcategory.put("Bus", Arrays.asList("AC Bus Ticket", "Non AC Bus Ticket", "other"));
        itemsBySubcategory.put("Hotel / Accommodation", Arrays.asList("Room Rent", "Breakfast Buffet", "Service Charge", "other"));
        itemsBySubcategory.put("Car / Bike Service", Arrays.asList("Oil Change", "Tyre Replacement", "Annual Service", "other"));
        itemsBySubcategory.put("Parking", Arrays.asList("Street Parking", "Mall Parking", "other"));
        itemsBySubcategory.put("Tolls & Road Tax", Arrays.asList("Autobahn Toll", "Highway Toll", "other"));
        itemsBySubcategory.put("Trips", Arrays.asList("Short Trip", "Long trip", "Anniversary Trip", "Birthday Trip",
                "Friends / Family Trip", "India Trip", "Vacation", "other"));

        // Health
        itemsBySubcategory.put("Pharmacy", Arrays.asList("Paracetamol", "Cough Syrup", "Antibiotics", "Ayurvedic Medicine", "other"));
        itemsBySubcategory.put("Doctor Consultation", Arrays.asList("General Physician", "Dentist", "Gynecologist", "other"));
        itemsBySubcategory.put("Diagnostic Tests", Arrays.asList("Blood Test", "X-Ray", "MRI", "Ultrasound", "other"));
        itemsBySubcategory.put("Hospital / Surgery", Arrays.asList("Admission Fee", "Operation Fee", "Emergency Fee", "other"));
        itemsBySubcategory.put("Dental Care", Arrays.asList("Cleaning", "Filling", "Root Canal", "other"));
        itemsBySubcategory.put("Optical / Eye Care", Arrays.asList("Eye Test", "Glasses", "Contact Lens", "other"));

        // Bills
        itemsBySubcategory.put("Mobile", Arrays.asList("Prepaid Recharge", "Postpaid Bill", "other"));
        itemsBySubcategory.put("TV & Streaming", Arrays.asList("Netflix", "Amazon Prime", "Disney+", "Sony Liv", "Hotstar", "other"));
        itemsBySubcategory.put("Internet", Arrays.asList("DSL Bill", "Fiber Optic Bill", "other"));
        itemsBySubcategory.put("Software & Cloud", Arrays.asList("Microsoft 365", "Google Workspace", "Dropbox", "Antivirus", "other"));
        itemsBySubcategory.put("Gym & Clubs", Arrays.asList("Monthly Fee", "Yoga Class", "Sports Club", "other"));
        itemsBySubcategory.put("Insurance Premiums", Arrays.asList("Health Insurance", "Life Insurance", "Car Insurance", "other"));

        // Education
        itemsBySubcategory.put("School Fees", Arrays.asList("Primary School", "High School", "other"));
        itemsBySubcategory.put("College Fees", Arrays.asList("Semester Fee", "Exam Fee", "other"));
        itemsBySubcategory.put("Courses & Certifications", Arrays.asList("Udemy", "Coursera", "Skillshare", "other"));
        itemsBySubcategory.put("Books & Study Material", Arrays.asList("Textbook", "Reference Book", "other"));
        itemsBySubcategory.put("Stationery", Arrays.asList("Pen", "Notebook", "Printer Ink", "other"));

        // Entertainment
        itemsBySubcategory.put("Dining Out", Arrays.asList("Restaurant Meal", "Street Food", "Fine Dining", "other"));
        itemsBySubcategory.put("Cafes / Coffee", Arrays.asList("Coffee", "Pastry", "Sandwich", "other"));
        itemsBySubcategory.put("Movies / Theater", Arrays.asList("Movie Ticket", "Theater Ticket", "other"));
        itemsBySubcategory.put("Concerts & Events", Arrays.asList("Concert Ticket", "Sports Event", "Exhibition", "other"));
        itemsBySubcategory.put("Amusement Parks", Arrays.asList("Theme Park Ticket", "Ride Pass", "other"));
        itemsBySubcategory.put("Video Games / Esports", Arrays.asList("PlayStation Game", "Xbox Game", "Esports Entry Fee", "other"));
        itemsBySubcategory.put("Travel Experiences", Arrays.asList("City Tour", "Museum Entry", "Adventure Sports", "other"));

        // Financial
        itemsBySubcategory.put("Bank Fees", Arrays.asList("ATM Fee", "Account Maintenance", "other"));
        itemsBySubcategory.put("Credit Card Payments", Arrays.asList("Visa", "Mastercard", "Amex", "other"));
        itemsBySubcategory.put("Brokerage / Investments", Arrays.asList("Stock Brokerage Fee", "Mutual Fund Purchase", "other"));
        itemsBySubcategory.put("Tax Payments", Arrays.asList("Income Tax", "Property Tax", "GST / VAT", "other"));
        itemsBySubcategory.put("Legal / Professional Services", Arrays.asList("Lawyer Fee", "Consulting Fee", "other"));

        // Gifts & Social
        itemsBySubcategory.put("Festivals", Arrays.asList("Diwali Shopping", "Christmas Tree", "Eid Food", "Holi Colors", "other"));
        itemsBySubcategory.put("Birthdays", Arrays.asList("Cake", "Gift", "other"));
        itemsBySubcategory.put("Weddings", Arrays.asList("Saree", "Sherwani", "Wedding Gift", "other"));
        itemsBySubcategory.put("Donations", Arrays.asList("Temple Donation", "Church Donation", "NGO", "other"));
        itemsBySubcategory.put("Gifts", Arrays.asList("Gift Card", "Perfume", "Flower Bouquet", "other"));

        // Loans
        itemsBySubcategory.put("Loan", Arrays.asList("HDFC", "ICICI", "COMMERZ BANK", "DEUTSCHE BANK", "TARGO BANK", "ConsumerLoans", "other"));

        // Recurring Payments
        itemsBySubcategory.put("Rent", Arrays.asList("Germany House", "India House", "other"));
        itemsBySubcategory.put("Chits", Arrays.asList("1 LAKH", "2 LAKHS", "5 LAKHS", "10 LAKHS", "15 LAKHS", "20 LAKHS", "other"));

        // Subscriptions
        itemsBySubcategory.put("Monthly", Arrays.asList("Amazon", "FlipKart", "Duolingo", "Wow", "Pluralsight", "edreams","Apple Music",
                "Apple One", "ICloud", "Google Cloud", "other"));
        itemsBySubcategory.put("Yearly", Arrays.asList("Amazon", "FlipKart", "Duolingo", "Wow", "Pluralsight", "edreams","Apple Music",
                "Apple One", "ICloud", "Google Cloud", "other"));

        // Other
        itemsBySubcategory.put("Pet Care", Arrays.asList("Pet Food", "Veterinary Visit", "Grooming", "other"));
        itemsBySubcategory.put("Travel Insurance", Arrays.asList("Short Trip Insurance", "Annual Plan", "other"));
        itemsBySubcategory.put("Unexpected Expenses", Arrays.asList("Penalty", "Late Fee", "Emergency Buy", "other"));

        // ---------------------------
        // Payment Methods, Units, Owners
        // ---------------------------
        List<String> paymentMethods = Arrays.asList(
                "Mobile Wallet (Paytm, PhonePe, GPay, Apple Pay)", "Debit Card", "Credit Card", "Bank Transfer",
                "UPI", "Cash", "Netbanking", "Cred Wallet", "other"
        );

        List<String> units = Arrays.asList(
                "pcs", "kg", "g", "l", "ml", "box", "pack", "dozen", "bottle", "pair", "hour", "month", "other"
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
