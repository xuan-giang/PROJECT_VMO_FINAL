package com.example.ex1_managementapartmentbuilding.service.Impl;

import com.example.ex1_managementapartmentbuilding.model.Tenant;
import com.example.ex1_managementapartmentbuilding.repository.TenantRepository;
import com.example.ex1_managementapartmentbuilding.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public Tenant create(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant update(int id, Tenant tenant) {
        Tenant updatedTenant = tenantRepository.findById(id);

        updatedTenant.setAddress(tenant.getAddress());
        updatedTenant.setEmail(tenant.getEmail());
        updatedTenant.setFullName(tenant.getFullName());
        updatedTenant.setPhone(tenant.getPhone());
        updatedTenant.setIdNo(tenant.getIdNo());

        return tenantRepository.save(updatedTenant);
    }

    @Override
    public List<Tenant> findAll() {
        return tenantRepository.findAll();
    }

    @Override
    public Tenant findTenantById(int id) {
        return tenantRepository.findById(id);
    }

    @Override
    public void delete(int id) {

    }
}
