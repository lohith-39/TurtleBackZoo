package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalShowDTO {

    private Integer asId;
    private Integer seniorPrice;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer perDay;
}
