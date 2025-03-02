package com.project.service;

import com.project.model.Vendor;
import com.project.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Create a new vendor
    public void createVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Get vendor by ID
    public Optional<Vendor> getVendorById(int vendorId) {
        return vendorRepository.findById(vendorId);
    }
}
