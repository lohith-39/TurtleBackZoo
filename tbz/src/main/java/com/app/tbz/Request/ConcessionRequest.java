package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConcessionRequest {

    private Integer concId;
    private String product;
}
