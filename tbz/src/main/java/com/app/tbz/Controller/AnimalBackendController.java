package com.app.tbz.Controller;

import com.app.tbz.Repository.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalBackendController {

    private AnimalRepository animalRepository;

    public AnimalBackendController(AnimalRepository animalRepository) {
        super();
        this.animalRepository = animalRepository;
    }

    @GetMapping("/getAnimalPopulationBySpecies")
    public String getAnimalPopulationBySpecies(Model model) {
        model.addAttribute("animals", animalRepository.getAnimalPopulationBySpecies());
        return "getAnimalPopulationBySpecies";
    }

    @GetMapping("/getTotalMonthlyFoodCostBySpecies")
    public String getTotalMonthlyFoodCostBySpecies(Model model) {
        model.addAttribute("foodCosts", animalRepository.getTotalMonthlyFoodCostBySpecies());
        return "getTotalMonthlyFoodCostBySpecies";
    }

    @GetMapping("/getCostsForAssignedPersonnel")
    public String getCostsForAssignedPersonnel(Model model) {
        model.addAttribute("costs", animalRepository.getCostsForAssignedPersonnel());
        return "getCostsForAssignedPersonnel";
    }
}
