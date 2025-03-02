package com.project.controller;

import com.project.model.Tender;
import com.project.service.TenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/tenders")
public class TenderController {

    private final TenderService tenderService;

    public TenderController(TenderService tenderService) {
        this.tenderService = tenderService;
    }

    @PostMapping
    public ResponseEntity<Void> createTender(@RequestBody Tender tender) {
        tenderService.createTender(tender);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tender>> getAllTenders() {
        List<Tender> tenders = tenderService.getAllTenders();
        return new ResponseEntity<>(tenders, HttpStatus.OK);
    }

    @GetMapping("/{tenderId}")
    public ResponseEntity<Tender> getTenderById(@PathVariable int tenderId) {
        Optional<Tender> tender = tenderService.getTenderById(tenderId);
        return tender.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
