package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnimalPopulationBySpecies {

    private String speciesName;
    private String animalStatus;
    private Long population;
}
