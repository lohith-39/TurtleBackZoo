package com.app.tbz.Controller;

import com.app.tbz.DTO.BuildingDTO;
import com.app.tbz.Entity.Building;
import com.app.tbz.Exception.BuildingNotFoundException;
import com.app.tbz.Request.BuildingRequest;
import com.app.tbz.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping("")
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingRequest request) {
        BuildingDTO response = buildingService.createBuilding(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{b_id}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable Integer b_id) throws BuildingNotFoundException {
        BuildingDTO response = buildingService.getBuilding(b_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{b_id}")
    public ResponseEntity<BuildingDTO> updateBuildingById(@PathVariable Integer b_id, @RequestBody BuildingRequest request) throws BuildingNotFoundException {
        BuildingDTO response = buildingService.updateBuilding(b_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Building>> getBuildings(){
        return new ResponseEntity<>(buildingService.getAllBuildings(), HttpStatus.OK);
    }
}
