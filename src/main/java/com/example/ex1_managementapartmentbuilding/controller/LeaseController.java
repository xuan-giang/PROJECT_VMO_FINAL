package com.example.ex1_managementapartmentbuilding.controller;

import com.example.ex1_managementapartmentbuilding.exception.NotFoundException;
import com.example.ex1_managementapartmentbuilding.model.Lease;
import com.example.ex1_managementapartmentbuilding.service.ApartmentService;
import com.example.ex1_managementapartmentbuilding.service.LeaseService;
import com.example.ex1_managementapartmentbuilding.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private TenantService tenantService;

    @PostMapping
    public ResponseEntity<?> createNewLease(@RequestParam( value = "apartment_id") Integer apartment_id,@RequestParam( value = "tenant_id") Integer tenant_id,@RequestBody Lease lease)
    {
        lease.setApartment(apartmentService.findApartmentById(apartment_id));
        lease.setTenant(tenantService.findTenantById(tenant_id));

        return ResponseEntity.ok().body(leaseService.create(lease));
    }

    @GetMapping
    public ResponseEntity<?> getAllLease()
    {
        return ResponseEntity.ok().body(leaseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLeaseById(@PathVariable Integer id)
    {
        checkObjectExist(id);
        return ResponseEntity.ok().body(leaseService.findLeaseById(id));
    }

    // Same to remove tenant from apartment
    @GetMapping("/disable")
    public ResponseEntity<?> disableLease(@RequestParam("lease_id") Integer lease_id)
    {
        checkObjectExist(lease_id);
        leaseService.disableLease(lease_id);
        return ResponseEntity.ok().body(leaseService.findLeaseById(lease_id));
    }

    @PatchMapping
    public ResponseEntity<?> updateLease(@RequestParam("lease_id") Integer id, @RequestBody Lease lease)
    {
        checkObjectExist(id);
        return ResponseEntity.ok().body(leaseService.update(id, lease));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLease(@RequestParam("lease_id") Integer id)
    {
        //leaseService.delete(id);
        leaseService.disableLease(id);
        return ResponseEntity.ok().body(leaseService.findLeaseById(id));
    }

    private void checkObjectExist(int id)
    {
        if(leaseService.findLeaseById(id) == null)
        {
            throw new NotFoundException("Cannot find lease with id " + id);
        }
    }
}
