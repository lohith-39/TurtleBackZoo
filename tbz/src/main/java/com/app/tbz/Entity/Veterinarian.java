package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VETERINARIAN")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veterinarian {

    @Id
    private Integer vetID;
}
