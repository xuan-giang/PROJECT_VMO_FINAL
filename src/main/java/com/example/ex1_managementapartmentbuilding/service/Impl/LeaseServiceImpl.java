package com.example.ex1_managementapartmentbuilding.service.Impl;

import com.example.ex1_managementapartmentbuilding.model.Apartment;
import com.example.ex1_managementapartmentbuilding.model.Lease;
import com.example.ex1_managementapartmentbuilding.model.Tenant;
import com.example.ex1_managementapartmentbuilding.repository.LeaseRepository;
import com.example.ex1_managementapartmentbuilding.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LeaseServiceImpl implements LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    public Lease create(Lease lease) {
        if(isAvailable(lease))
        {
            lease.setStatus(1);
            Apartment apartment = lease.getApartment();
            apartment.setStatus(1);
            lease.setApartment(apartment);
            return leaseRepository.save(lease);
        }else {
            return null;
        }
    }

    private boolean isAvailable(Lease lease)
    {
        // Check apartment null and tenant don't have valid lease
        return lease.getApartment().getStatus() == 0 && !hadLease(lease.getTenant());
    }

    private boolean hadLease(Tenant tenant)
    {
        List<Lease> leaseList = leaseRepository.findAll();
        for(Lease lease : leaseList)
        {
            if(lease.getStatus() == 1 && Objects.equals(lease.getTenant().getId(), tenant.getId()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Lease update(int id, Lease lease) {
        Lease updatedLease = leaseRepository.findById(id);
        updatedLease.setApartment(lease.getApartment());
        updatedLease.setTenant(lease.getTenant());
        updatedLease.setStatus(lease.getStatus());
        updatedLease.setDeposit(lease.getDeposit());
        updatedLease.setEndDate(lease.getEndDate());
        updatedLease.setStartDate(lease.getStartDate());

        return leaseRepository.save(updatedLease);
    }

    @Override
    public void disableLease(int id)
    {
        Lease updatedLease = leaseRepository.findById(id);
        Apartment updatedApartment = updatedLease.getApartment();
        updatedApartment.setStatus(0);

        updatedLease.setStatus(0);
        updatedLease.setApartment(updatedApartment);

        leaseRepository.save(updatedLease);
    }

    @Override
    public Lease findLeaseByApartment(Apartment apartment) {
        return leaseRepository.findByApartmentAndAndStatus(apartment, 1);
    }

    @Override
    public void delete(int id) {
        leaseRepository.deleteById(id);
    }

    @Override
    public List<Lease> findAll() {
        return leaseRepository.findAll();
    }

    @Override
    public Lease findLeaseById(int id) {
        return leaseRepository.findById(id);
    }


}
