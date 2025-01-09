package com.app.tbz.Controller;

import com.app.tbz.Exception.HourlyRateNotFoundException;
import com.app.tbz.Request.HourlyRateRequest;
import com.app.tbz.Service.HourlyRateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HourlyRateBackendController {

    private HourlyRateService hourlyRateService;

    public HourlyRateBackendController(HourlyRateService hourlyRateService) {
        super();
        this.hourlyRateService = hourlyRateService;
    }

    @GetMapping("/hourlyratemanagement")
    public String hourlyratemanagementPage() {
        return "hourlyratemanagement";
    }

    @GetMapping("/createHourlyRate")
    public String addBuildingForm() {
        return "createHourlyRate";
    }

    @PostMapping("/createHourlyRate")
    public String createHourlyRate(Model model, @ModelAttribute HourlyRateRequest hourlyRateRequest) {
        model.addAttribute("createHourlyRate", hourlyRateService.createHourlyRate(hourlyRateRequest));
        return "redirect:/getAllHourlyRates";
    }

    @GetMapping("/getAllHourlyRates")
    public String listHourlyRates(Model model) {
        model.addAttribute("getAllHourlyRates", hourlyRateService.getAllHourlyRates());
        return "getAllHourlyRates";
    }

    @GetMapping("/editHourlyRate/{h_id}")
    public String getHourlyRateById(Model model, @PathVariable("h_id") Integer h_id) throws HourlyRateNotFoundException {
        model.addAttribute("hourlyRate", hourlyRateService.getHourlyRate(h_id));
        return "updateHourlyRate";
    }

    @PostMapping("/updateHourlyRate/{h_id}")
    public String updateHourlyRate(@PathVariable("h_id") Integer h_id, @ModelAttribute("hourlyRate") HourlyRateRequest hourlyRateRequest) throws HourlyRateNotFoundException {
        hourlyRateService.updateHourlyRate(h_id, hourlyRateRequest);
        return "redirect:/getAllHourlyRates";
    }
}
