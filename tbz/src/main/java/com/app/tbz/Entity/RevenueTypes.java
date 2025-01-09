package com.app.tbz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REVENUE_TYPES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevenueTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer R_ID;

    private Integer B_ID;

    private String name;

    private String type;
}
