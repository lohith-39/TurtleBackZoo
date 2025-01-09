package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ANIMAL_CARE_SPECIALIST")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalCareSpecialist {

    @Id
    private Integer acsID;

}
