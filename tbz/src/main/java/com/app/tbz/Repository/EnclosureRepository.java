package com.app.tbz.Repository;

import com.app.tbz.Entity.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnclosureRepository extends JpaRepository<Enclosure, Integer> {

    @Query("SELECT e FROM Enclosure e where e.ID = :e_id")
    Enclosure findByE_id(@Param("e_id") Integer e_id);

    @Query("SELECT e FROM Enclosure e where e.B_ID = :b_id")
    Enclosure findByB_id(@Param("b_id") Integer b_id);
}
