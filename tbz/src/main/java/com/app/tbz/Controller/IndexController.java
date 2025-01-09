package com.app.tbz.Controller;

import com.app.tbz.DTO.AnimalDTO;
import com.app.tbz.DTO.AnimalPopulationBySpecies;
import com.app.tbz.DTO.CostsForAssignedPersonnel;
import com.app.tbz.DTO.MonthlyFoodCostBySpecies;
import com.app.tbz.Exception.AnimalNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Request.AnimalRequest;
import com.app.tbz.Service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {

    private AnimalService animalService;

    public IndexController(AnimalService animalService){
        super();
        this.animalService=animalService;
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/assetmanagement")
    public String assetmanagementPage(){
        return "assetmanagement";
    }

    @GetMapping("/dailyzooactivitymanagement")
    public String dailyzooactivitymanagementPage(){
        return "dailyzooactivitymanagement";
    }

    @GetMapping("/managementandreporting")
    public String managementandreportingPage(){
        return "managementandreporting";
    }

    @GetMapping("/averageRevenue")
    public String averageRevenue(){
        return "averageRevenue";
    }

    @GetMapping("/getCosts")
    public String getCosts(){
        return "getCosts";
    }

    @GetMapping("/animalmanagement")
    public String animalmanagementPage(){
        return "animalmanagement";
    }

    @GetMapping("/createAnimal")
    public String addAnimalForm() {
        return "createAnimal";
    }

    @PostMapping("/createAnimal")
    public String createAnimal(Model model, @ModelAttribute AnimalRequest animal) throws InsertCannotBeDoneException {
        model.addAttribute("createAnimal", animalService.createAnimal(animal));
        return "redirect:/getAllAnimals";
    }

    @GetMapping("/getAllAnimals")
    public String listAnimals(Model model){
        model.addAttribute("getAllAnimals", animalService.getAllAnimals());
        return "getAllAnimals";
    }

    @GetMapping("/editAnimal/{a_id}")
    public String getAnimalById(Model model, @PathVariable("a_id") Integer a_id) throws AnimalNotFoundException {
        model.addAttribute("animal", animalService.getAnimal(a_id));
        return "updateAnimal";
    }

    @PostMapping("/updateAnimal/{a_id}")
    public String updateAnimal(@PathVariable("a_id") Integer a_id, @ModelAttribute("animal") AnimalRequest animalRequest) throws AnimalNotFoundException, UpdateCannotBeDoneException {
        animalService.updateAnimal(a_id, animalRequest);
        return "redirect:/getAllAnimals";
    }
}