package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AverageRevenueForConcession {

    private String Concession;
    private Double AverageRevenue;
}
