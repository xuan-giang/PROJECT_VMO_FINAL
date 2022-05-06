package com.example.ex1_managementapartmentbuilding.service;

import com.example.ex1_managementapartmentbuilding.model.Apartment;

import java.util.List;

public interface ApartmentService {

    void create(Apartment apartment);

    Apartment update(int id, Apartment apartment);

    List<Apartment> findAll();

    Apartment findApartmentById(int id);

    Apartment findApartmentByName(String name);

    void delete(int id);
}
