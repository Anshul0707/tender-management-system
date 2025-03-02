package com.project.repository;

import com.project.model.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VendorRepository {

    private final JdbcTemplate jdbcTemplate;

    public VendorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create a new vendor
    public void save(Vendor vendor) {
        String sql = "INSERT INTO vendor (vendor_name, vendor_email, vendor_phone, vendor_address) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, vendor.getVendorName(), vendor.getVendorEmail(), vendor.getVendorPhone(), vendor.getVendorAddress());
    }

    // Find all vendors
    public List<Vendor> findAll() {
        String sql = "SELECT * FROM vendor";
        return jdbcTemplate.query(sql, vendorRowMapper());
    }

    // Find vendor by ID
    public Optional<Vendor> findById(int vendorId) {
        String sql = "SELECT * FROM vendor WHERE vendor_id = ?";
        return jdbcTemplate.query(sql, vendorRowMapper(), vendorId).stream().findFirst();
    }

    // RowMapper for Vendor
    private RowMapper<Vendor> vendorRowMapper() {
        return (rs, rowNum) -> {
            Vendor vendor = new Vendor();
            vendor.setVendorId(rs.getInt("vendor_id"));
            vendor.setVendorName(rs.getString("vendor_name"));
            vendor.setVendorEmail(rs.getString("vendor_email"));
            vendor.setVendorPhone(rs.getString("vendor_phone"));
            vendor.setVendorAddress(rs.getString("vendor_address"));
            return vendor;
        };
    }
}
