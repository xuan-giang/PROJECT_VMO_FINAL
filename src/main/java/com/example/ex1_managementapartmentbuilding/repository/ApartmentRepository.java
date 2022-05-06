package com.example.ex1_managementapartmentbuilding.repository;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    Apartment findById(int id);

    Apartment findByName(String name);
}
