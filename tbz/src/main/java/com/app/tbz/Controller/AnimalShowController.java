package com.app.tbz.Controller;

import com.app.tbz.DTO.AnimalShowDTO;
import com.app.tbz.Entity.AnimalShow;
import com.app.tbz.Exception.AnimalShowNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Request.AnimalShowRequest;
import com.app.tbz.Request.AnimalShowUpdateRequest;
import com.app.tbz.Service.AnimalShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animalshow")
public class AnimalShowController {

    @Autowired
    private AnimalShowService animalShowService;

    @PostMapping("")
    public ResponseEntity<AnimalShowDTO> createAnimalShow(@RequestBody AnimalShowRequest request) throws InsertCannotBeDoneException {
        AnimalShowDTO response = animalShowService.createAnimalShow(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{as_id}")
    public ResponseEntity<AnimalShowDTO> getAnimalShowById(@PathVariable Integer as_id) throws AnimalShowNotFoundException {
        AnimalShowDTO response = animalShowService.getAnimalShow(as_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{as_id}")
    public ResponseEntity<AnimalShowDTO> updateAnimalShowById(@PathVariable Integer as_id, @RequestBody AnimalShowUpdateRequest request) throws AnimalShowNotFoundException {
        AnimalShowDTO response = animalShowService.updateAnimalShow(as_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<AnimalShow>> getAnimalShows(){
        return new ResponseEntity<>(animalShowService.getAllAnimalShows(), HttpStatus.OK);

    }
}
