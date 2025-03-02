package com.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DatabaseInitializationService {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializationService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initializeDatabase() {
        createVendorTableIfNotExists();
        createTenderTableIfNotExists();
        createBidTableIfNotExists();
    }

    private void createVendorTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS vendor (" +
                "vendor_id SERIAL PRIMARY KEY, " +
                "vendor_name VARCHAR(100) NOT NULL, " +
                "vendor_email VARCHAR(100) UNIQUE NOT NULL, " +
                "vendor_phone VARCHAR(15), " +
                "vendor_address VARCHAR(200)" +
                ")";
        jdbcTemplate.execute(sql);
        logger.info("Vendor table created or already exists.");
    }

    private void createTenderTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS tender (" +
                "tender_id SERIAL PRIMARY KEY, " +
                "tender_name VARCHAR(100) NOT NULL, " +
                "tender_description VARCHAR(500), " +
                "tender_status VARCHAR(20) DEFAULT 'OPEN', " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
        jdbcTemplate.execute(sql);
        logger.info("Tender table created or already exists.");
    }

    private void createBidTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS bid (" +
                "bid_id SERIAL PRIMARY KEY, " +
                "tender_id INTEGER REFERENCES tender(tender_id), " +
                "vendor_id INTEGER REFERENCES vendor(vendor_id), " +
                "bid_amount NUMERIC(10, 2) NOT NULL, " +
                "bid_status VARCHAR(20) DEFAULT 'PENDING', " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
        jdbcTemplate.execute(sql);
        logger.info("Bid table created or already exists.");
    }
}
