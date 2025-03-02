package com.project.controller;

import com.project.model.Bid;
import com.project.service.BidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendor/bids")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping
    public ResponseEntity<Void> placeBid(@RequestBody Bid bid) {
        bidService.placeBid(bid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/tender/{tenderId}")
    public ResponseEntity<List<Bid>> getBidsByTenderId(@PathVariable int tenderId) {
        List<Bid> bids = bidService.getBidsByTenderId(tenderId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @GetMapping("/{bidId}")
    public ResponseEntity<Bid> getBidById(@PathVariable int bidId) {
        Optional<Bid> bid = bidService.getBidById(bidId);
        return bid.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{bidId}/select")
    public ResponseEntity<Void> selectBid(@PathVariable int bidId) {
        bidService.selectBid(bidId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Bid>> getBidHistoryByVendorId(@PathVariable int vendorId) {
        List<Bid> bids = bidService.getBidHistoryByVendorId(vendorId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }
}
