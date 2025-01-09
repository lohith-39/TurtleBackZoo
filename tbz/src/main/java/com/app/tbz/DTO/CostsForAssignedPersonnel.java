package com.app.tbz.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CostsForAssignedPersonnel {

    private String firstName;
    private String lastName;
    private String jobType;
    private Long monthlyCost;
}
