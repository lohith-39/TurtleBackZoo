package com.app.tbz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Participates_In")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ParticipatesInId.class)
public class ParticipatesIn {

    @Id
    private Integer sID;

    @Id
    private Integer asID;

    private Integer required;
}
