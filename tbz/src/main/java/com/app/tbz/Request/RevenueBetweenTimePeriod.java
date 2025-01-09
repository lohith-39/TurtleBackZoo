package com.app.tbz.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevenueBetweenTimePeriod {

    private LocalDate startDate;
    private LocalDate endDate;
}
