package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalShowRequest {

    private Integer as_id;
    private Integer seniorPrice;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer perDay;
}
