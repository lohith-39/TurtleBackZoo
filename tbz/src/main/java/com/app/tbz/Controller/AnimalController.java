package com.app.tbz.Controller;

import com.app.tbz.DTO.AnimalDTO;
import com.app.tbz.Entity.Animal;
import com.app.tbz.Exception.AnimalNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Request.AnimalRequest;
import com.app.tbz.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("")
    public ResponseEntity<AnimalDTO> createAnimal(@RequestBody AnimalRequest request) throws InsertCannotBeDoneException {
        AnimalDTO response = animalService.createAnimal(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{a_id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Integer a_id) throws AnimalNotFoundException {
        AnimalDTO response = animalService.getAnimal(a_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{a_id}")
    public ResponseEntity<AnimalDTO> updateAnimalById(@PathVariable Integer a_id, @RequestBody AnimalRequest request) throws AnimalNotFoundException, UpdateCannotBeDoneException {
        AnimalDTO response = animalService.updateAnimal(a_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Animal>> getAnimals(){
        List<Animal> animalList = animalService.getAllAnimals();
        return new ResponseEntity<>(animalList, HttpStatus.OK);
    }
}