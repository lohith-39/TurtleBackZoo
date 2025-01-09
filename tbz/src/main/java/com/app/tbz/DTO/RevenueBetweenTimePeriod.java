package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RevenueBetweenTimePeriod {

    private String Attraction;
    private Long TotalRevenue;
}
