package com.app.tbz.Controller;

import com.app.tbz.DTO.HourlyRateDTO;
import com.app.tbz.Entity.HourlyRate;
import com.app.tbz.Exception.HourlyRateNotFoundException;
import com.app.tbz.Request.HourlyRateRequest;
import com.app.tbz.Service.HourlyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hourlyrate")
public class HourlyRateController {

    @Autowired
    private HourlyRateService hourlyRateService;

    @PostMapping("")
    public ResponseEntity<HourlyRateDTO> createHourlyRate(@RequestBody HourlyRateRequest request) {
        HourlyRateDTO response = hourlyRateService.createHourlyRate(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{h_id}")
    public ResponseEntity<HourlyRateDTO> getHourlyRateById(@PathVariable Integer h_id) throws HourlyRateNotFoundException {
        HourlyRateDTO response = hourlyRateService.getHourlyRate(h_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{h_id}")
    public ResponseEntity<HourlyRateDTO> updateHourlyRateById(@PathVariable Integer h_id, @RequestBody HourlyRateRequest request) throws HourlyRateNotFoundException {
        HourlyRateDTO response = hourlyRateService.updateHourlyRate(h_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<HourlyRate>> getHourlyRates(){
        return new ResponseEntity<>(hourlyRateService.getAllHourlyRates(), HttpStatus.OK);

    }
}
