package com.app.tbz.Service;

import com.app.tbz.DTO.AnimalDTO;
import com.app.tbz.Entity.Animal;
import com.app.tbz.Entity.Enclosure;
import com.app.tbz.Entity.Species;
import com.app.tbz.Exception.AnimalNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Repository.AnimalRepository;
import com.app.tbz.Repository.EnclosureRepository;
import com.app.tbz.Repository.SpeciesRepository;
import com.app.tbz.Request.AnimalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private EnclosureRepository enclosureRepository;

    @Override
    public AnimalDTO createAnimal(AnimalRequest request) throws InsertCannotBeDoneException {
        if(request.getS_id() != null) {
            Optional<Species> species = speciesRepository.findById(request.getS_id());
            if(species.isEmpty()){
                throw new InsertCannotBeDoneException("Species ID Not Present in the Species Table");
            }
        }
        if(request.getE_id() != null) {
            Enclosure enclosure = enclosureRepository.findByE_id(request.getE_id());
            if(enclosure == null){
                throw new InsertCannotBeDoneException("Enclosure ID Not Present in the Enclosure Table");
            }
        }
        if(request.getB_id() != null) {
            Enclosure enclosure = enclosureRepository.findByB_id(request.getB_id());
            if(enclosure == null){
                throw new InsertCannotBeDoneException("Enclosure ID Not Present in the Enclosure Table");
            }
        }
        Animal animal = animalRepository.save(toAnimalEntity(request));
        return AnimalDTO.builder()
                .a_id(animal.getA_ID())
                .b_id(animal.getBId())
                .birth_Year(animal.getBirthYear())
                .status(animal.getStatus())
                .s_id(animal.getSId())
                .id(animal.getId()).build();
    }

    private Animal toAnimalEntity(AnimalRequest request) {
        return Animal.builder()
                .status(request.getStatus())
                .birthYear(request.getBirth_Year())
                .id(request.getE_id())
                .bId(request.getB_id())
                .sId(request.getS_id())
                .build();
    }

    @Override
    public AnimalDTO getAnimal(Integer a_id) throws AnimalNotFoundException {
        Optional<Animal> optional = animalRepository.findById(a_id);
        if(optional.isEmpty()){
            throw new AnimalNotFoundException("Animal Not Found");
        }
        return AnimalDTO.builder()
                .a_id(optional.get().getA_ID())
                .id(optional.get().getId())
                .s_id(optional.get().getSId())
                .b_id(optional.get().getBId())
                .status(optional.get().getStatus())
                .birth_Year(optional.get().getBirthYear())
                .build();
    }

    @Override
    public AnimalDTO updateAnimal(Integer a_id, AnimalRequest request) throws AnimalNotFoundException, UpdateCannotBeDoneException {
        Optional<Animal> existingAnimal = animalRepository.findById(a_id);
        if(existingAnimal.isEmpty()){
            throw new AnimalNotFoundException("Animal Not Found");
        }
        if(request.getStatus() != null) {
            existingAnimal.get().setStatus(request.getStatus());
        }
        if(request.getBirth_Year() != null) {
            existingAnimal.get().setBirthYear(request.getBirth_Year());
        }
        if(request.getS_id() != null) {
            Optional<Species> species = speciesRepository.findById(request.getS_id());
            if(species.isEmpty()){
                throw new UpdateCannotBeDoneException("Species ID Not Present in the Species Table");
            }
            existingAnimal.get().setSId(request.getS_id());
        }
        if(request.getE_id() != null) {
            Enclosure enclosure = enclosureRepository.findByE_id(request.getE_id());
            if(enclosure == null){
                throw new UpdateCannotBeDoneException("Enclosure ID Not Present in the Enclosure Table");
            }
            existingAnimal.get().setId(request.getE_id());
        }
        if(request.getB_id() != null) {
            Enclosure enclosure = enclosureRepository.findByB_id(request.getB_id());
            if(enclosure == null){
                throw new UpdateCannotBeDoneException("Enclosure ID Not Present in the Enclosure Table");
            }
            existingAnimal.get().setBId(request.getB_id());
        }

        Animal animal = animalRepository.save(existingAnimal.get());

        return AnimalDTO.builder()
                .a_id(animal.getA_ID())
                .b_id(animal.getBId())
                .birth_Year(animal.getBirthYear())
                .status(animal.getStatus())
                .s_id(animal.getSId())
                .id(animal.getId()).build();
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
}
