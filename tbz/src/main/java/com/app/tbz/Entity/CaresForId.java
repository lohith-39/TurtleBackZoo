package com.app.tbz.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaresForId implements Serializable {

    private Integer sID;

    private Integer vetID;

    private Integer acsID;
}
