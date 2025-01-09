package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AverageRevenueForEachAttraction {

    private String Attraction;
    private Double AverageRevenue;
}
