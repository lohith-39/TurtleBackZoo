package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CARES_FOR")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CaresForId.class)
public class CaresFor {

    @Id
    private Integer sID;

    @Id
    private Integer vetID;

    @Id
    private Integer acsID;
}
