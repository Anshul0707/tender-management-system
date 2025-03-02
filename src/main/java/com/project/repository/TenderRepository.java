package com.project.repository;

import com.project.model.Tender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TenderRepository {

    private final JdbcTemplate jdbcTemplate;

    public TenderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create a new tender
    public void save(Tender tender) {
        String sql = "INSERT INTO tender (tender_name, tender_description) VALUES (?, ?)";
        jdbcTemplate.update(sql, tender.getTenderName(), tender.getTenderDescription());
    }

    // Find all tenders
    public List<Tender> findAll() {
        String sql = "SELECT * FROM tender";
        return jdbcTemplate.query(sql, tenderRowMapper());
    }

    // Find tender by ID
    public Optional<Tender> findById(int tenderId) {
        String sql = "SELECT * FROM tender WHERE tender_id = ?";
        return jdbcTemplate.query(sql, tenderRowMapper(), tenderId).stream().findFirst();
    }

    // RowMapper for Tender
    private RowMapper<Tender> tenderRowMapper() {
        return (rs, rowNum) -> {
            Tender tender = new Tender();
            tender.setTenderId(rs.getInt("tender_id"));
            tender.setTenderName(rs.getString("tender_name"));
            tender.setTenderDescription(rs.getString("tender_description"));
            tender.setTenderStatus(rs.getString("tender_status"));
            tender.setCreatedAt(rs.getString("created_at"));
            return tender;
        };
    }
}
