package com.example.ex1_managementapartmentbuilding.service;

import com.example.ex1_managementapartmentbuilding.model.Building;
import com.example.ex1_managementapartmentbuilding.model.Lease;

import java.util.List;

public interface BuildingService {

    Building create(Building building);

    Building update(int id, Building building);

    List<Building> findAll();

    Building findBuildingById(int id);

    void delete(int id);
}
