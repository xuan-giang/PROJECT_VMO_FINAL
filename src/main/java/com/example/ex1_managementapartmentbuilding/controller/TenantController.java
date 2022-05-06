package com.example.ex1_managementapartmentbuilding.controller;

import com.example.ex1_managementapartmentbuilding.model.Tenant;
import com.example.ex1_managementapartmentbuilding.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public ResponseEntity<?> getAllTenants()
    {
        return ResponseEntity.ok().body(tenantService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewTenants(@RequestBody Tenant tenant)
    {
        return ResponseEntity.ok().body(tenantService.create(tenant));
    }

    @PatchMapping
    public ResponseEntity<?> updateTenant(@RequestParam("tenant_id") Integer id, @RequestBody Tenant tenant)
    {
        return ResponseEntity.ok().body(tenantService.update(id, tenant));
    }

    @PutMapping
    public ResponseEntity<?> updateTenant1(@RequestParam("tenant_id") Integer id, @RequestBody Tenant tenant)
    {
        return ResponseEntity.ok().body(tenantService.update(id, tenant));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTenant(@RequestParam("tenant_id") Integer id)
    {
        tenantService.delete(id);
        return ResponseEntity.ok().body("Object is deleted successfully!");
    }
}
