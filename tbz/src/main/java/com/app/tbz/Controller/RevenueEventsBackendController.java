package com.app.tbz.Controller;

import com.app.tbz.DTO.AverageRevenueForEachAttraction;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.RevenueEventNotFoundException;
import com.app.tbz.Request.*;
import com.app.tbz.Service.RevenueEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RevenueEventsBackendController {

    private RevenueEventService revenueEventService;

    public RevenueEventsBackendController(RevenueEventService revenueEventService) {
        super();
        this.revenueEventService = revenueEventService;
    }

    @GetMapping("/revenueeventmanagement")
    public String revenueeventmanagementPage() {
        return "revenueeventmanagement";
    }

    @GetMapping("/createRevenueEvent")
    public String addRevenueEventForm() {
        return "createRevenueEvent";
    }

    @PostMapping("/createRevenueEvent")
    public String createRevenueEvent(Model model, @ModelAttribute RevenueRequest revenueRequest) throws InsertCannotBeDoneException {
        model.addAttribute("createRevenueEvent", revenueEventService.createRevenueEvent(revenueRequest));
        return "redirect:/getAllRevenueEvents";
    }

    @GetMapping("/getAllRevenueEvents")
    public String listRevenueEvents(Model model) {
        model.addAttribute("getAllRevenueEvents", revenueEventService.getAllRevenueEvents());
        return "getAllRevenueEvents";
    }

    @GetMapping("/editRevenueEvent/{re_id}")
    public String getRevenueEventById(Model model, @PathVariable("re_id") Integer re_id) throws RevenueEventNotFoundException {
        model.addAttribute("revenueEvent", revenueEventService.getRevenueEvent(re_id));
        return "updateRevenueEvent";
    }

    @PostMapping("/updateRevenueEvent/{re_id}")
    public String updateRevenueEvent(@PathVariable("re_id") Integer re_id, @ModelAttribute("revenueEvent") RevenueUpdateRequest revenueUpdateRequest) throws RevenueEventNotFoundException {
        revenueEventService.updateRevenueEvent(re_id, revenueUpdateRequest);
        return "redirect:/getAllRevenueEvents";
    }

    @GetMapping("/getRevenueBySources")
    public String getRevenueEventBySources(){
        return "getRevenueBySource";
    }

    @PostMapping("/getRevenueBySourceByDay")
    public String getRevenues(Model model, @ModelAttribute RevenueBySourceRequest revenueBySourceRequest) {
        model.addAttribute("revenueBySource", revenueEventService.getReveueBySource(revenueBySourceRequest));
        return "getRevenueBySource";
    }

    @GetMapping("/getTopAttractions")
    public String getTopAttractions(){
        return "getTop5Attractions";
    }

    @PostMapping("/getAttractionsBetweenTime")
    public String getAttractionsBetweenTime(Model model, @ModelAttribute RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        model.addAttribute("attraction", revenueEventService.getTopAttractionsInTimePeriod(revenueBetweenTimePeriod));
        return "getTop5Attractions";
    }

    @GetMapping("/fiveBestDays")
    public String getTopDays(){
        return "getTop5Days";
    }

    @PostMapping("/getfiveBestDays")
    public String getTopDaysInaMonth(Model model, @ModelAttribute BestDaysRequest bestDaysRequest) {
        model.addAttribute("bestDays", revenueEventService.getBestDaysInMonth(bestDaysRequest));
        return "getTop5Days";
    }

    @GetMapping("/attractionRevenues")
    public String getAverageRevenueForAttraction(){
        return "attractionrevenue";
    }

    @PostMapping("/averageRevenueForAttraction")
    public String getAverageRevenueForAttraction(Model model, @ModelAttribute RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        model.addAttribute("averageRevenue", revenueEventService.getAverageRevenueForEachAttraction(revenueBetweenTimePeriod));
        return "attractionrevenue";
    }

    @GetMapping("/concessionRevenues")
    public String getAverageRevenueForConcession(){
        return "concessionrevenue";
    }

    @PostMapping("/averageRevenueForConcession")
    public String getAverageRevenueForConcession(Model model, @ModelAttribute RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        model.addAttribute("concession", revenueEventService.getAverageRevenueForEachConcession(revenueBetweenTimePeriod));
        return "concessionrevenue";
    }

    @GetMapping("/Attendance")
    public String getAverageAttendance(){
        return "attendance";
    }

    @PostMapping("/getAttendanceBetweenTime")
    public String getAverageAttendance(Model model, @ModelAttribute RevenueBetweenTimePeriod revenueBetweenTimePeriod) {
        model.addAttribute("attendance", revenueEventService.getAverageAttendance(revenueBetweenTimePeriod));
        return "attendance";
    }

}
