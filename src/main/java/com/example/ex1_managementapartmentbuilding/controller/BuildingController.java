package com.example.ex1_managementapartmentbuilding.controller;

import com.example.ex1_managementapartmentbuilding.exception.ForeignKeyException;
import com.example.ex1_managementapartmentbuilding.exception.NotFoundException;
import com.example.ex1_managementapartmentbuilding.model.Building;
import com.example.ex1_managementapartmentbuilding.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<?> getAllBuilding()
    {
        return ResponseEntity.ok().body(buildingService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewBuilding(@RequestBody Building building)
    {
        return ResponseEntity.ok().body(buildingService.create(building));
    }

    @PatchMapping
    public ResponseEntity<?> updateBuilding(@RequestParam("building_id") Integer id, @RequestBody Building building)
    {
        return ResponseEntity.ok().body(buildingService.update(id, building));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBuilding(@RequestParam("building_id") Integer id)
    {
        buildingService.delete(id);
        return ResponseEntity.ok().body("Object is deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBuildingById(@PathVariable Integer id)
    {
        if(buildingService.findBuildingById(id) == null)
        {
            throw new NotFoundException("Cannot find building with id " + id);
        }
        return ResponseEntity.ok().body(buildingService.findBuildingById(id));
    }
}
