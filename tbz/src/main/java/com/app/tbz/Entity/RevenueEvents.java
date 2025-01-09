package com.app.tbz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="REVENUE_EVENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RevenueEventsId.class)
public class RevenueEvents {

    @Id
    private Integer Re_ID;

    @Id
    private LocalDate datecolumn;

    private Integer revenue;

    private Integer ticketsSold;

}
