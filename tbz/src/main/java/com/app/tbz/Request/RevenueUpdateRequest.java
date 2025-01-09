package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RevenueUpdateRequest {

    private Integer revenue;
    private Integer ticketsSold;
}
