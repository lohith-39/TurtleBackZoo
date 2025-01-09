package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HourlyRateDTO {

    private Integer hId;
    private Integer rate;
}
