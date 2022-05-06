package com.example.ex1_managementapartmentbuilding.controller;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import com.example.ex1_managementapartmentbuilding.model.Building;
import com.example.ex1_managementapartmentbuilding.service.ApartmentService;

import com.example.ex1_managementapartmentbuilding.service.BuildingService;
import com.example.ex1_managementapartmentbuilding.service.LeaseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private LeaseService leaseService;

    @GetMapping
    public ResponseEntity<?> getAllApartment()
    {
        return ResponseEntity.ok().body(apartmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewApartment(@RequestParam( value = "building_id") Integer building_id,@RequestBody Apartment apartment)
    {
        Building building = buildingService.findBuildingById(building_id);
        apartment.setBuilding(building);
        apartmentService.create(apartment);
        building.setAmountDepartment(building.getAmountDepartment()+1);
        buildingService.update(building_id, building);
        return ResponseEntity.ok().body(apartmentService.findAll());
    }


    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam("name_apartment") String name_apartment)
    {
        Apartment apartment = apartmentService.findApartmentByName(name_apartment);
        if(apartment != null)
        {
            if(apartment.getStatus() == 0)
            {
                return ResponseEntity.ok().body(apartment);
            }else {
                return ResponseEntity.ok().body(leaseService.findLeaseByApartment(apartment));
            }
        }else
        {
            return ResponseEntity.ok().body("Không tìm thấy!");
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateApartment(@RequestParam("apartment_id") Integer id, @RequestBody Apartment apartment)
    {
        return ResponseEntity.ok().body(apartmentService.update(id, apartment));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteApartment(@RequestParam("apartment_id") Integer id)
    {
        apartmentService.delete(id);
        return ResponseEntity.ok().body("Object is deleted successfully!");
    }

}
