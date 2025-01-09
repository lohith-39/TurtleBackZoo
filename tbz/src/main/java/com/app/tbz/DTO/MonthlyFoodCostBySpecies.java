package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MonthlyFoodCostBySpecies {

    private String speciesName;
    private Long monthlyFoodCost;
}
