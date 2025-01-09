package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ZOO_ADMISSION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZooAdmission {

    @Id
    private Integer zaID;

    private Integer seniorPrice;

    private Integer adultPrice;

    private Integer childPrice;
}
