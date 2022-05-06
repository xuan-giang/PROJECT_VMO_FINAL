package com.example.ex1_managementapartmentbuilding.repository;

import com.example.ex1_managementapartmentbuilding.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    Building findById(int id);
}
