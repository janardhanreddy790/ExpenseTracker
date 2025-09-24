CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    category VARCHAR(100) NOT NULL,
    subcategory VARCHAR(100),
    item VARCHAR(200),
    quantity NUMERIC,
    unit VARCHAR(50),
    amount NUMERIC NOT NULL,
    currency VARCHAR(10) DEFAULT 'EUR',
    payment_method VARCHAR(50),
    vendor VARCHAR(100),
    owner VARCHAR(100),
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
