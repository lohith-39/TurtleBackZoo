package com.app.tbz.Service;

import com.app.tbz.DTO.AnimalDTO;
import com.app.tbz.Entity.Animal;
import com.app.tbz.Exception.AnimalNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Request.AnimalRequest;

import java.util.List;

public interface AnimalService {

    AnimalDTO createAnimal(AnimalRequest request) throws InsertCannotBeDoneException;
    AnimalDTO getAnimal(Integer a_id) throws AnimalNotFoundException;

    AnimalDTO updateAnimal(Integer a_id, AnimalRequest request) throws AnimalNotFoundException, UpdateCannotBeDoneException;

    List<Animal> getAllAnimals();
}
