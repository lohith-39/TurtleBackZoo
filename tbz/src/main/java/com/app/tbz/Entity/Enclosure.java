package com.app.tbz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ENCLOSURE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EnclosureId.class)
public class Enclosure {

    @Id
    private Integer ID;

    @Id
    private Integer B_ID;

    private Integer sqft;
}
