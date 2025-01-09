package com.app.tbz.Repository;

import com.app.tbz.DTO.AnimalPopulationBySpecies;
import com.app.tbz.DTO.CostsForAssignedPersonnel;
import com.app.tbz.DTO.MonthlyFoodCostBySpecies;
import com.app.tbz.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // Animal population by species and status
    @Query("SELECT new com.app.tbz.DTO.AnimalPopulationBySpecies(S.name, A.status, COUNT(A.A_ID)) " +
            "FROM Animal A " +
            "JOIN Species S ON A.sId = S.sId " +
            "GROUP BY S.name, A.status " +
            "ORDER BY S.name, A.status")
    List<AnimalPopulationBySpecies> getAnimalPopulationBySpecies();

    // Total monthly food cost by species
    @Query("SELECT new com.app.tbz.DTO.MonthlyFoodCostBySpecies(S.name , SUM(S.foodCost)) " +
            "FROM Species S " +
            "GROUP BY S.name " +
            "ORDER BY S.name")
    List<MonthlyFoodCostBySpecies> getTotalMonthlyFoodCostBySpecies();

    // Costs for assigned veterinarians and animal care specialists
    @Query("SELECT new com.app.tbz.DTO.CostsForAssignedPersonnel(E.first, E.last, E.jobType, SUM(HR.rate * 40 * 5)) " +
            "FROM Employee E " +
            "LEFT JOIN HourlyRate HR ON E.hId = HR.H_ID " +
            "WHERE E.jobType IN ('Veterinarian', 'Animal Care Specialist') " +
            "GROUP BY E.first, E.last, E.jobType " +
            "ORDER BY E.jobType, E.first, E.last")
    List<CostsForAssignedPersonnel> getCostsForAssignedPersonnel();
}
