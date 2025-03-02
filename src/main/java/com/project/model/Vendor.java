package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    private int vendorId;
    private String vendorName;
    private String vendorEmail;
    private String vendorPhone;
    private String vendorAddress;
}
