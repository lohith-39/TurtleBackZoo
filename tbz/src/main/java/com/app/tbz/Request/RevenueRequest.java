package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RevenueRequest {

    private Integer reID;
    private LocalDate DateColumn;
    private Integer revenue;
    private Integer ticketsSold;
}
