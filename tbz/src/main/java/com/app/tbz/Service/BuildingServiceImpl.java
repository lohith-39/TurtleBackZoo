package com.app.tbz.Service;

import com.app.tbz.DTO.BuildingDTO;
import com.app.tbz.Entity.Building;
import com.app.tbz.Exception.BuildingNotFoundException;
import com.app.tbz.Repository.BuildingRepository;
import com.app.tbz.Request.BuildingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public BuildingDTO createBuilding(BuildingRequest request) {
        Building building = buildingRepository.save(toBuildingEntity(request));
        return BuildingDTO.builder()
                .b_id(building.getB_ID())
                .name(building.getName())
                .type(building.getType())
                .build();
    }

    private Building toBuildingEntity(BuildingRequest request) {
        return Building.builder()
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    @Override
    public BuildingDTO getBuilding(Integer b_id) throws BuildingNotFoundException {
        Optional<Building> optional = buildingRepository.findById(b_id);
        if(optional.isEmpty()){
            throw new BuildingNotFoundException("Building Not Found");
        }
        return BuildingDTO.builder()
                .b_id(optional.get().getB_ID())
                .name(optional.get().getName())
                .type(optional.get().getType())
                .build();
    }

    @Override
    public BuildingDTO updateBuilding(Integer b_id, BuildingRequest request) throws BuildingNotFoundException {
        Optional<Building> existingBuilding= buildingRepository.findById(b_id);
        if(existingBuilding.isEmpty()){
            throw new BuildingNotFoundException("Building Not Found");
        }
        if(request.getName() != null) {
            existingBuilding.get().setName(request.getName());
        }
        if(request.getType() != null) {
            existingBuilding.get().setType(request.getType());
        }

        Building building = buildingRepository.save(existingBuilding.get());

        return BuildingDTO.builder()
                .b_id(building.getB_ID())
                .name(building.getName())
                .type(building.getType())
                .build();
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }
}