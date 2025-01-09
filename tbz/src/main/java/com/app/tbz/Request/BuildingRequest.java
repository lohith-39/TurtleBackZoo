package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingRequest {

    private String name;
    private String type;
}
