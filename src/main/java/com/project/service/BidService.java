package com.project.service;

import com.project.model.Bid;
import com.project.repository.BidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    // Place a bid
    public void placeBid(Bid bid) {
        bidRepository.save(bid);
    }

    // Get all bids for a tender
    public List<Bid> getBidsByTenderId(int tenderId) {
        return bidRepository.findByTenderId(tenderId);
    }

    // Get bid by ID
    public Optional<Bid> getBidById(int bidId) {
        return bidRepository.findById(bidId);
    }

    // Select a bid
    public void selectBid(int bidId) {
        bidRepository.updateBidStatus(bidId, "SELECTED");
    }

    // Get bid history for a vendor
    public List<Bid> getBidHistoryByVendorId(int vendorId) {
        return bidRepository.findByVendorId(vendorId);
    }
}
