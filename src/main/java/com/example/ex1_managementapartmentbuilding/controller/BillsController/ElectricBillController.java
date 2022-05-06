package com.example.ex1_managementapartmentbuilding.controller.BillsController;

import com.example.ex1_managementapartmentbuilding.model.Payments.ElectricPayment;
import com.example.ex1_managementapartmentbuilding.service.BillsService.ElectricBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill/electric")
public class ElectricBillController {

    @Autowired
    private ElectricBillService electricBillService;

    @GetMapping
    public ResponseEntity<?> getAllElectricBills()
    {
        return ResponseEntity.ok().body(electricBillService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewElectricBill(@RequestBody ElectricPayment electricPayment)
    {
        electricPayment.caculateFee();
        return ResponseEntity.ok().body(electricBillService.create(electricPayment));
    }

    @PatchMapping
    public ResponseEntity<?> updateElectricBill(@RequestParam("electric_payment_id") Integer id ,@RequestBody ElectricPayment electricPayment)
    {
        electricPayment.caculateFee();
        return ResponseEntity.ok().body(electricBillService.update(id, electricPayment));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteElectricBill(@RequestParam("electric_payment_id") Integer id)
    {
        electricBillService.delete(id);
        return new ResponseEntity<>("Object is deleted successsfully", HttpStatus.OK);
    }
}
