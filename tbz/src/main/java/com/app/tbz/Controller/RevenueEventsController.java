package com.app.tbz.Controller;

import com.app.tbz.DTO.*;
import com.app.tbz.Entity.RevenueEvents;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.RevenueEventNotFoundException;
import com.app.tbz.Request.BestDaysRequest;
import com.app.tbz.Request.RevenueBySourceRequest;
import com.app.tbz.Request.RevenueRequest;
import com.app.tbz.Request.RevenueUpdateRequest;
import com.app.tbz.Service.RevenueEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenueevent")
public class RevenueEventsController {

    @Autowired
    private RevenueEventService revenueEventService;

    @PostMapping("")
    public ResponseEntity<RevenueEventDTO> createRevenueEvent(@RequestBody RevenueRequest request) throws InsertCannotBeDoneException {
        RevenueEventDTO response = revenueEventService.createRevenueEvent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{re_id}")
    public ResponseEntity<RevenueEventDTO> getRevenueEventById(@PathVariable Integer re_id) throws RevenueEventNotFoundException {
        RevenueEventDTO response = revenueEventService.getRevenueEvent(re_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{re_id}")
    public ResponseEntity<RevenueEventDTO> updateRevenueEventById(@PathVariable Integer re_id, @RequestBody RevenueUpdateRequest request) throws RevenueEventNotFoundException {
        RevenueEventDTO response = revenueEventService.updateRevenueEvent(re_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<RevenueEvents>> getRevenueEvents(){
        return new ResponseEntity<>(revenueEventService.getAllRevenueEvents(), HttpStatus.OK);

    }

    @PostMapping("/revenue")
    public ResponseEntity<List<RevenueBySource>> getRevenueBySource(@RequestBody RevenueBySourceRequest revenueBySourceRequest){
        return new ResponseEntity<>(revenueEventService.getReveueBySource(revenueBySourceRequest), HttpStatus.OK);
    }

    @PostMapping("/revenuebetweentimeperiod")
    public ResponseEntity<List<RevenueBetweenTimePeriod>> getRevenueBetweenTimePeriod(@RequestBody com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod){
        return new ResponseEntity<>(revenueEventService.getTopAttractionsInTimePeriod(revenueBetweenTimePeriod), HttpStatus.OK);
    }

    @PostMapping("/revenueofyearandmonth")
    public ResponseEntity<List<BestDays>> getBestDaysInAYearAndMonth(@RequestBody BestDaysRequest bestDaysRequest){
        return new ResponseEntity<>(revenueEventService.getBestDaysInMonth(bestDaysRequest), HttpStatus.OK);
    }

    @PostMapping("/revenueofeachattraction")
    public ResponseEntity<List<AverageRevenueForEachAttraction>> getAverageForEachAttraction(@RequestBody com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod){
        return new ResponseEntity<>(revenueEventService.getAverageRevenueForEachAttraction(revenueBetweenTimePeriod), HttpStatus.OK);
    }

    @PostMapping("/revenueofeachconcession")
    public ResponseEntity<List<AverageRevenueForConcession>> getAverageForEachConcession(@RequestBody com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod){
        return new ResponseEntity<>(revenueEventService.getAverageRevenueForEachConcession(revenueBetweenTimePeriod), HttpStatus.OK);
    }

    @PostMapping("/averagetotalattendance")
    public ResponseEntity<AverageTotalAttendance> getAverageAttendance(@RequestBody com.app.tbz.Request.RevenueBetweenTimePeriod revenueBetweenTimePeriod){
        return new ResponseEntity<>(revenueEventService.getAverageAttendance(revenueBetweenTimePeriod), HttpStatus.OK);
    }
}
