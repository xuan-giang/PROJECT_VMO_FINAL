package com.example.ex1_managementapartmentbuilding.controller.BillsController;

import com.example.ex1_managementapartmentbuilding.model.Payments.InternetPayment;
import com.example.ex1_managementapartmentbuilding.service.BillsService.InternetBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bill/internet")
public class InternetBillController {

    @Autowired
    private InternetBillService internetBillService;

    @GetMapping
    public ResponseEntity<?> getAllInternetBills()
    {
        return ResponseEntity.ok().body(internetBillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInternetBillById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(internetBillService.findInternetPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewInternetBill(@RequestBody InternetPayment internetPayment)
    {
        return ResponseEntity.ok().body(internetBillService.create(internetPayment));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteInternetBill(@RequestParam("internet_payment_id") Integer id)
    {
        internetBillService.delete(id);
        return new ResponseEntity<>("Object is deleted successsfully", HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateInternetBill(@RequestParam("internet_payment_id") Integer id, @RequestBody InternetPayment internetPayment)
    {
        return ResponseEntity.ok().body(internetBillService.update(id, internetPayment));
    }
}
