package com.app.tbz.Service;

import com.app.tbz.DTO.*;
import com.app.tbz.Entity.RevenueEvents;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.RevenueEventNotFoundException;
import com.app.tbz.Request.BestDaysRequest;
import com.app.tbz.Request.RevenueBySourceRequest;
import com.app.tbz.Request.RevenueRequest;
import com.app.tbz.Request.RevenueUpdateRequest;
import com.app.tbz.Response.RevenueResponseList;

import java.util.List;

public interface RevenueEventService {

    RevenueEventDTO createRevenueEvent(RevenueRequest request) throws InsertCannotBeDoneException;
    RevenueEventDTO getRevenueEvent(Integer re_id) throws RevenueEventNotFoundException;

    RevenueEventDTO updateRevenueEvent(Integer re_id, RevenueUpdateRequest request) throws RevenueEventNotFoundException;

    List<RevenueEvents> getAllRevenueEvents();

    List<RevenueBySource> getReveueBySource(RevenueBySourceRequest revenueBySourceRequest);

    List<RevenueBetweenTimePeriod> getTopAttractionsInTimePeriod(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod);

    List<BestDays> getBestDaysInMonth(BestDaysRequest bestDaysRequest);

    List<AverageRevenueForEachAttraction> getAverageRevenueForEachAttraction(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod);

    List<AverageRevenueForConcession> getAverageRevenueForEachConcession(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod);

    AverageTotalAttendance getAverageAttendance(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod);
}
