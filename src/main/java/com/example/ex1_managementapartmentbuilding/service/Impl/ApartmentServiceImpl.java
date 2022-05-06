package com.example.ex1_managementapartmentbuilding.service.Impl;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import com.example.ex1_managementapartmentbuilding.repository.ApartmentRepository;
import com.example.ex1_managementapartmentbuilding.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public void create(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public Apartment update(int id, Apartment apartment) {
        Apartment updatedApartment = apartmentRepository.findById(id);
        updatedApartment.setName(apartment.getName());
        updatedApartment.setSize(apartment.getSize());
        updatedApartment.setType(apartment.getType());
        //updatedApartment.setStatus(apartment.getStatus());
        updatedApartment.setBuilding(apartment.getBuilding());
        updatedApartment.setAmount_room(apartment.getAmount_room());

        return apartmentRepository.save(updatedApartment);
    }

    @Override
    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public Apartment findApartmentById(int id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public Apartment findApartmentByName(String name) {
        return apartmentRepository.findByName(name);
    }

    @Override
    public void delete(int id) {
        apartmentRepository.deleteById(id);
    }


}
