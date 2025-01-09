package com.app.tbz.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConcessionDTO {
    private Integer concId;
    private String product;
}
