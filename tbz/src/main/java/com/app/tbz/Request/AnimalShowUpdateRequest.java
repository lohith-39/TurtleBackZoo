package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalShowUpdateRequest {

    private Integer seniorPrice;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer perDay;
}
