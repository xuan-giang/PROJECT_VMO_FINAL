package com.example.ex1_managementapartmentbuilding.controller;

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
        return ResponseEntity.ok().body(leaseService.findLeaseById(id));
    }

    // Same to remove tenant from apartment
    @GetMapping("/disable")
    public ResponseEntity<?> disableLease(@RequestParam("lease_id") Integer lease_id)
    {
        leaseService.disableLease(lease_id);
        return ResponseEntity.ok().body(leaseService.findLeaseById(lease_id));
    }

    @PatchMapping
    public ResponseEntity<?> updateLease(@RequestParam("lease_id") Integer id, @RequestBody Lease lease)
    {
        return ResponseEntity.ok().body(leaseService.update(id, lease));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLease(@RequestParam("lease_id") Integer id)
    {
        //leaseService.delete(id);
        return ResponseEntity.ok().body("Cannot delete lease!");
    }
}
