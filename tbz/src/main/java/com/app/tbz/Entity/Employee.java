package com.app.tbz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eId;

    private LocalDate startDate;

    private String jobType;

    private String first;

    private String minit;

    private String last;

    private String street;

    private String state;

    private String city;

    private String zip;

    private Integer hId;

    private Integer concId;

    private Integer zaId;

}
