package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CONCESSION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concession {

    @Id
    private Integer concId;

    private String product;
}
