package com.app.tbz.Repository;

import com.app.tbz.DTO.*;
import com.app.tbz.Entity.RevenueEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RevenueEventRepository extends JpaRepository<RevenueEvents, Integer> {

    @Query("SELECT e FROM RevenueEvents e where e.Re_ID = :Re_id")
    RevenueEvents findByRe_id(@Param("Re_id") Integer Re_id);

    @Query("SELECT new com.app.tbz.DTO.RevenueBySource(t .R_ID, t .name, e .revenue, " +
            "e .datecolumn, e .ticketsSold, t .type) " +
            "FROM RevenueEvents e JOIN RevenueTypes t ON e .Re_ID = t .R_ID " +
            "WHERE e .datecolumn = :date")
    List<RevenueBySource> getRevenueBySourceForDay(@Param("date") LocalDate date);

    @Query("SELECT new com.app.tbz.DTO.RevenueBetweenTimePeriod(RT.name, SUM(RE.revenue))" +
            "FROM RevenueEvents RE " +
            "JOIN RevenueTypes RT ON RE.Re_ID = RT.R_ID " +
            "WHERE RE.datecolumn BETWEEN :startDate AND :endDate " +
            "GROUP BY RT.name " +
            "ORDER BY SUM(RE.revenue) DESC " +
            "LIMIT 3")
    List<RevenueBetweenTimePeriod> getTopAttractionsInTimePeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT new com.app.tbz.DTO.BestDays(RE.datecolumn, SUM(RE.revenue))" +
            "FROM RevenueEvents RE " +
            "WHERE YEAR(RE.datecolumn) = :year AND MONTH(RE.datecolumn) = :month " +
            "GROUP BY RE.datecolumn " +
            "ORDER BY SUM(RE.revenue) DESC " +
            "LIMIT 5")
    List<BestDays> getBestDaysInMonth(@Param("year") int year, @Param("month") int month);

    @Query("SELECT new com.app.tbz.DTO.AverageRevenueForEachAttraction(RT.name, AVG(RE.revenue)) " +
            "FROM RevenueEvents RE " +
            "JOIN RevenueTypes RT ON RE.Re_ID = RT.R_ID " +
            "WHERE RE.datecolumn BETWEEN :startDate AND :endDate " +
            "GROUP BY RT.name")
    List<AverageRevenueForEachAttraction> getAverageRevenueForAttractions(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT new com.app.tbz.DTO.AverageRevenueForConcession(C.product, AVG(RE.revenue)) " +
            "FROM RevenueEvents RE " +
            "JOIN Concession C ON RE.Re_ID = C.concId " +
            "WHERE RE.datecolumn BETWEEN :startDate AND :endDate " +
            "GROUP BY C.product")
    List<AverageRevenueForConcession> getAverageRevenueForConcessions(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT new com.app.tbz.DTO.AverageTotalAttendance(AVG(RE.ticketsSold)) " +
            "FROM RevenueEvents RE " +
            "WHERE RE.datecolumn BETWEEN :startDate AND :endDate")
    AverageTotalAttendance getAverageTotalAttendance(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}