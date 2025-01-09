package com.app.tbz.Service;

import com.app.tbz.DTO.AnimalShowDTO;
import com.app.tbz.Entity.AnimalShow;
import com.app.tbz.Entity.RevenueTypes;
import com.app.tbz.Exception.AnimalShowNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Repository.AnimalShowRepository;
import com.app.tbz.Repository.RevenueTypesRepository;
import com.app.tbz.Request.AnimalShowRequest;
import com.app.tbz.Request.AnimalShowUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalShowServiceImpl implements AnimalShowService{

    @Autowired
    private AnimalShowRepository animalShowRepository;

    @Autowired
    private RevenueTypesRepository revenueTypesRepository;

    @Override
    public AnimalShowDTO createAnimalShow(AnimalShowRequest request) throws InsertCannotBeDoneException {
        Optional<RevenueTypes> revenueTypes = revenueTypesRepository.findById(request.getAs_id());
        if(revenueTypes.isEmpty()){
            throw new InsertCannotBeDoneException("Revenue Types ID Not Present in the Revenue Types Table");
        }
        AnimalShow animalShow = animalShowRepository.save(toAnimalShowEntity(request));
        return AnimalShowDTO.builder()
                .asId(animalShow.getAsId())
                .adultPrice(animalShow.getAdultPrice())
                .childPrice(animalShow.getChildPrice())
                .seniorPrice(animalShow.getSeniorPrice())
                .perDay(animalShow.getPerDay())
                .build();
    }

    private AnimalShow toAnimalShowEntity(AnimalShowRequest request) {
        return AnimalShow.builder()
                .asId(request.getAs_id())
                .adultPrice(request.getAdultPrice())
                .childPrice(request.getChildPrice())
                .seniorPrice(request.getSeniorPrice())
                .perDay(request.getPerDay())
                .build();
    }

    @Override
    public AnimalShowDTO getAnimalShow(Integer as_id) throws AnimalShowNotFoundException {
        Optional<AnimalShow> optional = animalShowRepository.findById(as_id);
        if(optional.isEmpty()){
            throw new AnimalShowNotFoundException("Animal Show Not Found");
        }
        return AnimalShowDTO.builder()
                .asId(optional.get().getAsId())
                .adultPrice(optional.get().getAdultPrice())
                .seniorPrice(optional.get().getSeniorPrice())
                .childPrice(optional.get().getChildPrice())
                .perDay(optional.get().getPerDay())
                .build();
    }

    @Override
    public AnimalShowDTO updateAnimalShow(Integer as_id, AnimalShowUpdateRequest request) throws AnimalShowNotFoundException {
        Optional<AnimalShow> existingAnimalShow = animalShowRepository.findById(as_id);
        if(existingAnimalShow.isEmpty()){
            throw new AnimalShowNotFoundException("Animal Show Not Found");
        }
        if(request.getPerDay() != null) {
            existingAnimalShow.get().setPerDay(request.getPerDay());
        }
        if(request.getAdultPrice() != null) {
            existingAnimalShow.get().setAdultPrice(request.getAdultPrice());
        }
        if(request.getChildPrice() != null) {
            existingAnimalShow.get().setChildPrice(request.getChildPrice());
        }
        if(request.getSeniorPrice() != null) {
            existingAnimalShow.get().setSeniorPrice(request.getSeniorPrice());
        }

        AnimalShow animalShow = animalShowRepository.save(existingAnimalShow.get());

        return AnimalShowDTO.builder()
                .asId(animalShow.getAsId())
                .childPrice(animalShow.getChildPrice())
                .seniorPrice(animalShow.getSeniorPrice())
                .adultPrice(animalShow.getAdultPrice())
                .perDay(animalShow.getPerDay())
                .build();
    }

    @Override
    public List<AnimalShow> getAllAnimalShows() {
        return animalShowRepository.findAll();
    }
}
