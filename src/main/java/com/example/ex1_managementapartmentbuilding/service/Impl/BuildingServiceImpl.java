package com.example.ex1_managementapartmentbuilding.service.Impl;

import com.example.ex1_managementapartmentbuilding.model.Building;
import com.example.ex1_managementapartmentbuilding.repository.BuildingRepository;
import com.example.ex1_managementapartmentbuilding.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building update(int id, Building building) {
        Building updatedBuilding = buildingRepository.findById(id);

        updatedBuilding.setAmountDepartment(building.getAmountDepartment());
        updatedBuilding.setName(building.getName());
        updatedBuilding.setAddress(building.getAddress());

        return buildingRepository.save(updatedBuilding);
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building findBuildingById(int id) {
        return buildingRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        buildingRepository.deleteById(id);
    }
}
