package com.app.tbz.Controller;

import com.app.tbz.Exception.AnimalShowNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Request.AnimalShowRequest;
import com.app.tbz.Request.AnimalShowUpdateRequest;
import com.app.tbz.Service.AnimalShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalShowBackendController {

    private AnimalShowService animalShowService;

    public AnimalShowBackendController(AnimalShowService animalShowService) {
        super();
        this.animalShowService = animalShowService;
    }

    @GetMapping("/animalshowmanagement")
    public String animalShowPage() {
        return "animalshowmanagement";
    }

    @GetMapping("/createAnimalShow")
    public String addAnimalShowForm() {
        return "createAnimalShow";
    }

    @PostMapping("/createAnimalShow")
    public String createAnimalShow(Model model, @ModelAttribute AnimalShowRequest animalShowRequest) throws InsertCannotBeDoneException {
        model.addAttribute("createAnimalShow", animalShowService.createAnimalShow(animalShowRequest));
        return "redirect:/getAllAnimalShows";
    }

    @GetMapping("/getAllAnimalShows")
    public String listAnimalShows(Model model) {
        model.addAttribute("getAllAnimalShows", animalShowService.getAllAnimalShows());
        return "getAllAnimalShows";
    }

    @GetMapping("/editAnimalShow/{as_id}")
    public String getAnimalShowById(Model model, @PathVariable("as_id") Integer as_id) throws AnimalShowNotFoundException {
        model.addAttribute("animalShow", animalShowService.getAnimalShow(as_id));
        return "updateAnimalShow";
    }

    @PostMapping("/updateAnimalShow/{as_id}")
    public String updateAnimalShow(@PathVariable("as_id") Integer as_id, @ModelAttribute("animalShow") AnimalShowUpdateRequest animalShowUpdateRequest) throws AnimalShowNotFoundException {
        animalShowService.updateAnimalShow(as_id, animalShowUpdateRequest);
        return "redirect:/getAllAnimalShows";
    }
}
