package com.app.tbz.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BestDays {

    private LocalDate revenueDate;
    private Long totalRevenue;
}
