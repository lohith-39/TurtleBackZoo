package com.app.tbz.Repository;

import com.app.tbz.Entity.RevenueTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RevenueTypesRepository extends JpaRepository<RevenueTypes, Integer> {

    @Query("SELECT e FROM RevenueTypes e where e.R_ID = :R_id")
    RevenueTypes findByR_id(@Param("R_id") Integer R_id);
}
