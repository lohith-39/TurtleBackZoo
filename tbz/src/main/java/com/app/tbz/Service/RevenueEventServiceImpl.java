package com.app.tbz.Service;

import com.app.tbz.DTO.*;
import com.app.tbz.Entity.RevenueEvents;
import com.app.tbz.Entity.RevenueTypes;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.RevenueEventNotFoundException;
import com.app.tbz.Repository.RevenueEventRepository;
import com.app.tbz.Repository.RevenueTypesRepository;
import com.app.tbz.Request.BestDaysRequest;
import com.app.tbz.Request.RevenueBySourceRequest;
import com.app.tbz.Request.RevenueRequest;
import com.app.tbz.Request.RevenueUpdateRequest;
import com.app.tbz.Response.RevenueResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueEventServiceImpl implements RevenueEventService {

    @Autowired
    private RevenueEventRepository revenueEventRepository;

    @Autowired
    private RevenueTypesRepository revenueTypesRepository;

    @Override
    public RevenueEventDTO createRevenueEvent(RevenueRequest request) throws InsertCannotBeDoneException {
        RevenueTypes revenueTypes = revenueTypesRepository.findByR_id(request.getReID());
        if(revenueTypes == null){
            throw new InsertCannotBeDoneException("Event Type ID Not Present in Event Type Table");
        }
        RevenueEvents revenueEvents = revenueEventRepository.save(toRevenueTypeEntity(request));
        return RevenueEventDTO.builder()
                .reID(revenueEvents.getRe_ID())
                .ticketsSold(revenueEvents.getTicketsSold())
                .DateColumn(revenueEvents.getDatecolumn())
                .revenue(revenueEvents.getRevenue())
                .build();
    }

    private RevenueEvents toRevenueTypeEntity(RevenueRequest request) {
        return RevenueEvents.builder()
                .Re_ID(request.getReID())
                .datecolumn(request.getDateColumn())
                .revenue(request.getRevenue())
                .ticketsSold(request.getTicketsSold())
                .build();
    }

    @Override
    public RevenueEventDTO getRevenueEvent(Integer re_id) throws RevenueEventNotFoundException {
        RevenueEvents revenueEvents = revenueEventRepository.findByRe_id(re_id);
        if(revenueEvents == null){
            throw new RevenueEventNotFoundException("Revenue Event Not Found");
        }
        return RevenueEventDTO.builder()
                .reID(revenueEvents.getRe_ID())
                .revenue(revenueEvents.getRevenue())
                .DateColumn(revenueEvents.getDatecolumn())
                .ticketsSold(revenueEvents.getTicketsSold())
                .build();
    }

    @Override
    public RevenueEventDTO updateRevenueEvent(Integer re_id, RevenueUpdateRequest request) throws RevenueEventNotFoundException {
        RevenueEvents existingRevenueEvent = revenueEventRepository.findByRe_id(re_id);
        if (existingRevenueEvent == null) {
            throw new RevenueEventNotFoundException("Revenue Event Not Found");
        }

        if (request.getRevenue()!= null) {
            existingRevenueEvent.setRevenue(request.getRevenue());
        }

        if (request.getTicketsSold()!= null) {
            existingRevenueEvent.setTicketsSold(request.getTicketsSold());
        }

        RevenueEvents revenueEvents = revenueEventRepository.save(existingRevenueEvent);

        return RevenueEventDTO.builder()
                .reID(revenueEvents.getRe_ID())
                .revenue(revenueEvents.getRevenue())
                .ticketsSold(revenueEvents.getTicketsSold())
                .DateColumn(revenueEvents.getDatecolumn())
                .build();
    }

    @Override
    public List<RevenueEvents> getAllRevenueEvents() {
        return revenueEventRepository.findAll();
    }

    @Override
    public List<RevenueBySource> getReveueBySource(RevenueBySourceRequest revenueBySourceRequest) {
         return revenueEventRepository.getRevenueBySourceForDay(revenueBySourceRequest.getDate());
    }

    @Override
    public List<RevenueBetweenTimePeriod> getTopAttractionsInTimePeriod(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        return revenueEventRepository.getTopAttractionsInTimePeriod(revenueBetweenTimePeriod.getStartDate(), revenueBetweenTimePeriod.getEndDate());
    }

    @Override
    public List<BestDays> getBestDaysInMonth(BestDaysRequest bestDaysRequest) {
        return revenueEventRepository.getBestDaysInMonth(bestDaysRequest.getYear(), bestDaysRequest.getMonth());
    }

    @Override
    public List<AverageRevenueForEachAttraction> getAverageRevenueForEachAttraction(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        return revenueEventRepository.getAverageRevenueForAttractions(revenueBetweenTimePeriod.getStartDate(), revenueBetweenTimePeriod.getEndDate());
    }

    @Override
    public List<AverageRevenueForConcession> getAverageRevenueForEachConcession(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        return revenueEventRepository.getAverageRevenueForConcessions(revenueBetweenTimePeriod.getStartDate(), revenueBetweenTimePeriod.getEndDate());
    }

    @Override
    public AverageTotalAttendance getAverageAttendance(com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        return revenueEventRepository.getAverageTotalAttendance(revenueBetweenTimePeriod.getStartDate(), revenueBetweenTimePeriod.getEndDate());
    }
}
