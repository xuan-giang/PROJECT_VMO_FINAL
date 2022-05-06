package com.example.ex1_managementapartmentbuilding.repository;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import com.example.ex1_managementapartmentbuilding.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Integer> {

    Lease findById(int id);

    Lease findByApartment(Apartment apartment);
}
