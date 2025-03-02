package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    private int bidId;
    private int tenderId;
    private int vendorId;
    private double bidAmount;
    private String bidStatus;
    private String createdAt;
}
