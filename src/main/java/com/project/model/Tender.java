package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tender {
    private int tenderId;
    private String tenderName;
    private String tenderDescription;
    private String tenderStatus;
    private String createdAt;
}
