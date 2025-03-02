package com.project.service;

import com.project.model.Tender;
import com.project.repository.TenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenderService {

    private final TenderRepository tenderRepository;

    public TenderService(TenderRepository tenderRepository) {
        this.tenderRepository = tenderRepository;
    }

    // Create a new tender
    public void createTender(Tender tender) {
        tenderRepository.save(tender);
    }

    // Get all tenders
    public List<Tender> getAllTenders() {
        return tenderRepository.findAll();
    }

    // Get tender by ID
    public Optional<Tender> getTenderById(int tenderId) {
        return tenderRepository.findById(tenderId);
    }
}
