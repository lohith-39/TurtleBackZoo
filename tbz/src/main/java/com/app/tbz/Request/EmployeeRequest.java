package com.app.tbz.Request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeRequest {
    private LocalDate startDate;
    private String jobType;
    private String first;
    private String minit;
    private String last;
    private String street;
    private String state;
    private String city;
    private String zip;
    private Integer h_id;
    private Integer conc_id;
    private Integer za_id;
}
