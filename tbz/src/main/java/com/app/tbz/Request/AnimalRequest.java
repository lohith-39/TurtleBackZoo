package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalRequest {

    private String status;
    private Integer birth_Year;
    private Integer s_id;
    private Integer e_id;
    private Integer b_id;
}
