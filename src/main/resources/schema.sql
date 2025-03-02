-- Vendor Table
CREATE TABLE vendor (
    vendor_id SERIAL PRIMARY KEY,
    vendor_name VARCHAR(100) NOT NULL,
    vendor_email VARCHAR(100) UNIQUE NOT NULL,
    vendor_phone VARCHAR(15),
    vendor_address VARCHAR(200)
);

-- Tender Table
CREATE TABLE tender (
    tender_id SERIAL PRIMARY KEY,
    tender_name VARCHAR(100) NOT NULL,
    tender_description VARCHAR(500),
    tender_status VARCHAR(20) DEFAULT 'OPEN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bid Table
CREATE TABLE bid (
    bid_id SERIAL PRIMARY KEY,
    tender_id INTEGER REFERENCES tender(tender_id),
    vendor_id INTEGER REFERENCES vendor(vendor_id),
    bid_amount NUMERIC(10, 2) NOT NULL,
    bid_status VARCHAR(20) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO vendor (vendor_name, vendor_email, vendor_phone, vendor_address)
VALUES
('Vendor A', 'vendorA@example.com', '1234567890', '123 Main St'),
('Vendor B', 'vendorB@example.com', '9876543210', '456 Elm St');


INSERT INTO tender (tender_name, tender_description)
VALUES
('Tender 1', 'Supply of goods'),
('Tender 2', 'Supply of services');

INSERT INTO bid (tender_id, vendor_id, bid_amount)
VALUES
(1, 1, 1000.00),
(1, 2, 1500.00),
(2, 1, 2000.00);
