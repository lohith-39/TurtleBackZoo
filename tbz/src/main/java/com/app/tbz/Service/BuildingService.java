package com.app.tbz.Service;

import com.app.tbz.DTO.BuildingDTO;
import com.app.tbz.Entity.Building;
import com.app.tbz.Exception.BuildingNotFoundException;
import com.app.tbz.Request.BuildingRequest;

import java.util.List;

public interface BuildingService {

    BuildingDTO createBuilding(BuildingRequest request);
    BuildingDTO getBuilding(Integer b_id) throws BuildingNotFoundException;
    BuildingDTO updateBuilding(Integer b_id, BuildingRequest request) throws BuildingNotFoundException;

    List<Building> getAllBuildings();
}
