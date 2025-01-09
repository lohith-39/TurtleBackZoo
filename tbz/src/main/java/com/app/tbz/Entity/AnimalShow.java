package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ANIMAL_SHOW")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalShow {

    @Id
    private Integer asId;

    private Integer seniorPrice;

    private Integer adultPrice;

    private Integer childPrice;

    private Integer perDay;
}
