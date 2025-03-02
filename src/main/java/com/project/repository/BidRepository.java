package com.project.repository;

import com.project.model.Bid;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BidRepository {

    private final JdbcTemplate jdbcTemplate;

    public BidRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Place a bid
    public void save(Bid bid) {
        String sql = "INSERT INTO bid (tender_id, vendor_id, bid_amount) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bid.getTenderId(), bid.getVendorId(), bid.getBidAmount());
    }

    // Find all bids for a tender
    public List<Bid> findByTenderId(int tenderId) {
        String sql = "SELECT * FROM bid WHERE tender_id = ?";
        return jdbcTemplate.query(sql, bidRowMapper(), tenderId);
    }

    // Find bid by ID
    public Optional<Bid> findById(int bidId) {
        String sql = "SELECT * FROM bid WHERE bid_id = ?";
        return jdbcTemplate.query(sql, bidRowMapper(), bidId).stream().findFirst();
    }

    // Update bid status (select a bid)
    public void updateBidStatus(int bidId, String status) {
        String sql = "UPDATE bid SET bid_status = ? WHERE bid_id = ?";
        jdbcTemplate.update(sql, status, bidId);
    }

    // Find all bids by vendor
    public List<Bid> findByVendorId(int vendorId) {
        String sql = "SELECT * FROM bid WHERE vendor_id = ?";
        return jdbcTemplate.query(sql, bidRowMapper(), vendorId);
    }

    // RowMapper for Bid
    private RowMapper<Bid> bidRowMapper() {
        return (rs, rowNum) -> {
            Bid bid = new Bid();
            bid.setBidId(rs.getInt("bid_id"));
            bid.setTenderId(rs.getInt("tender_id"));
            bid.setVendorId(rs.getInt("vendor_id"));
            bid.setBidAmount(rs.getDouble("bid_amount"));
            bid.setBidStatus(rs.getString("bid_status"));
            bid.setCreatedAt(rs.getString("created_at"));
            return bid;
        };
    }
}
