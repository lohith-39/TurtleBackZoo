package com.app.tbz.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RevenueBySource {

    private Integer R_ID;
    private String name;
    private Integer revenue;
    private LocalDate datecolumn;
    private Integer ticketsSold;
    private String type;
}
