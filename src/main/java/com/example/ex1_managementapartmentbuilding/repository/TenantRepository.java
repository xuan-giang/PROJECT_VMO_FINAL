package com.example.ex1_managementapartmentbuilding.repository;

import com.example.ex1_managementapartmentbuilding.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

    Tenant findById(int id);
}
