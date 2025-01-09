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
@Table(name="TICKET_SELLER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TicketSellerId.class)
public class TicketSeller {

    @Id
    private Integer tsID;

    @Id
    private Integer zaID;
}
