package com.app.tbz.Service;

import com.app.tbz.DTO.HourlyRateDTO;
import com.app.tbz.Entity.HourlyRate;
import com.app.tbz.Exception.HourlyRateNotFoundException;
import com.app.tbz.Repository.HourlyRateRepository;
import com.app.tbz.Request.HourlyRateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourlyRateServiceImpl implements HourlyRateService{

    @Autowired
    private HourlyRateRepository hourlyRateRepository;

    @Override
    public HourlyRateDTO createHourlyRate(HourlyRateRequest request) {
        HourlyRate hourlyRate = hourlyRateRepository.save(toHourlyRateEntity(request));
        return HourlyRateDTO.builder()
                .hId(hourlyRate.getH_ID())
                .rate(hourlyRate.getRate())
                .build();
    }

    private HourlyRate toHourlyRateEntity(HourlyRateRequest request) {
        return HourlyRate.builder()
                .rate(request.getRate())
                .build();
    }

    @Override
    public HourlyRateDTO getHourlyRate(Integer h_id) throws HourlyRateNotFoundException {
        Optional<HourlyRate> optional = hourlyRateRepository.findById(h_id);
        if(optional.isEmpty()){
            throw new HourlyRateNotFoundException("Hourly Rate Not Found");
        }
        return HourlyRateDTO.builder()
                .hId(optional.get().getH_ID())
                .rate(optional.get().getRate())
                .build();
    }

    @Override
    public HourlyRateDTO updateHourlyRate(Integer h_id, HourlyRateRequest request) throws HourlyRateNotFoundException {
        Optional<HourlyRate> existingHourlyRate = hourlyRateRepository.findById(h_id);
        if(existingHourlyRate.isEmpty()){
            throw new HourlyRateNotFoundException("Hourly Rate Not Found");
        }

        if(request.getRate()!= null) {
            existingHourlyRate.get().setRate(request.getRate());
        }

        HourlyRate hourlyRate = hourlyRateRepository.save(existingHourlyRate.get());

        return HourlyRateDTO.builder()
                .hId(hourlyRate.getH_ID())
                .rate(hourlyRate.getRate())
                .build();
    }

    @Override
    public List<HourlyRate> getAllHourlyRates() {
        return hourlyRateRepository.findAll();
    }
}
