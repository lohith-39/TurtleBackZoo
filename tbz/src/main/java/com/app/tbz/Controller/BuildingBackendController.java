package com.app.tbz.Controller;

import com.app.tbz.Exception.BuildingNotFoundException;
import com.app.tbz.Request.BuildingRequest;
import com.app.tbz.Service.BuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuildingBackendController {

    private BuildingService buildingService;

    public BuildingBackendController(BuildingService buildingService) {
        super();
        this.buildingService = buildingService;
    }

    @GetMapping("/buildingmanagement")
    public String buildingmanagementPage() {
        return "buildingmanagement";
    }

    @GetMapping("/createBuilding")
    public String addBuildingForm() {
        return "createBuilding";
    }

    @PostMapping("/createBuilding")
    public String createBuilding(Model model, @ModelAttribute BuildingRequest buildingRequest) {
        model.addAttribute("createBuilding", buildingService.createBuilding(buildingRequest));
        return "redirect:/getAllBuildings";
    }

    @GetMapping("/getAllBuildings")
    public String listBuildings(Model model) {
        model.addAttribute("getAllBuildings", buildingService.getAllBuildings());
        return "getAllBuildings";
    }

    @GetMapping("/editBuilding/{b_id}")
    public String getBuildingById(Model model, @PathVariable("b_id") Integer b_id) throws BuildingNotFoundException {
        model.addAttribute("building", buildingService.getBuilding(b_id));
        return "updateBuilding";
    }

    @PostMapping("/updateBuilding/{b_id}")
    public String updateBuilding(@PathVariable("b_id") Integer b_id, @ModelAttribute("building") BuildingRequest buildingRequest) throws BuildingNotFoundException {
        buildingService.updateBuilding(b_id, buildingRequest);
        return "redirect:/getAllBuildings";
    }
}
