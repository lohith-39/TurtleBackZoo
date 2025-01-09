package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDTO {

    private Integer b_id;
    private String name;
    private String type;
}
