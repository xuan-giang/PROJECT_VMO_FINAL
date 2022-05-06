package com.example.ex1_managementapartmentbuilding.service;

import com.example.ex1_managementapartmentbuilding.model.Tenant;

import java.util.List;

public interface TenantService {
    Tenant create(Tenant tenant);

    Tenant update(int id, Tenant tenant);

    List<Tenant> findAll();

    Tenant findTenantById(int id);

    void delete(int id);
}
