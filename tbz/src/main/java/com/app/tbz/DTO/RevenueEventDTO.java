package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RevenueEventDTO {

    private Integer reID;
    private LocalDate DateColumn;
    private Integer revenue;
    private Integer ticketsSold;
}
