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
@Table(name="CUSTOMER_SERVICE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CustomerServiceId.class)
public class CustomerService {

    @Id
    private Integer csID;

    @Id
    private Integer concID;
}
