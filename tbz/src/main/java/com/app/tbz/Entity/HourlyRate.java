package com.app.tbz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HOURLY_RATE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HourlyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer H_ID;

    private Integer rate;
}
