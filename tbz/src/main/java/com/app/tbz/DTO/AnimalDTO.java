package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDTO {
    private Integer a_id;
    private String status;
    private Integer birth_Year;
    private Integer s_id;
    private Integer id;
    private Integer b_id;
}
