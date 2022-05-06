package com.example.ex1_managementapartmentbuilding.service;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import com.example.ex1_managementapartmentbuilding.model.Lease;

import java.util.List;

public interface LeaseService {

    Lease create(Lease lease);

    Lease update(int id, Lease lease);

    List<Lease> findAll();

    Lease findLeaseById(int id);

    void disableLease(int id);

    Lease findLeaseByApartment(Apartment apartment);

    void delete(int id);
}
