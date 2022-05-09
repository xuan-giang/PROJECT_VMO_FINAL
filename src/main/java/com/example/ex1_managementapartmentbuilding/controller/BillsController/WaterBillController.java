package com.example.ex1_managementapartmentbuilding.controller.BillsController;

import com.example.ex1_managementapartmentbuilding.exception.NotFoundException;
import com.example.ex1_managementapartmentbuilding.model.Payments.WaterPayment;
import com.example.ex1_managementapartmentbuilding.service.BillsService.WaterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill/water")
public class WaterBillController {

    @Autowired
    private WaterBillService waterBillService;

    @GetMapping
    public ResponseEntity<?> getAllWaterBills()
    {
        return ResponseEntity.ok().body(waterBillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWaterBillById(@PathVariable Integer id)
    {
        checkObjectExist(id);
        return ResponseEntity.ok().body(waterBillService.findWaterPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewWaterBill(@RequestBody WaterPayment waterPayment)
    {
        waterPayment.caculateFee();
        return ResponseEntity.ok().body(waterBillService.create(waterPayment));
    }

    @PatchMapping
    public ResponseEntity<?> updateWaterBill(@RequestParam("water_payment_id") Integer id, @RequestBody WaterPayment waterPayment)
    {
        checkObjectExist(id);
        waterPayment.caculateFee();
        return ResponseEntity.ok().body(waterBillService.update(id, waterPayment));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteWaterBill(@RequestParam("water_payment_id") Integer id)
    {
        checkObjectExist(id);
        waterBillService.delete(id);
        return new ResponseEntity<>("Object is deleted successsfully", HttpStatus.OK);
    }

    private void checkObjectExist(int id)
    {
        if(waterBillService.findWaterPaymentById(id) == null)
        {
            throw new NotFoundException("Cannot find water bill with id " + id);
        }
    }
}
