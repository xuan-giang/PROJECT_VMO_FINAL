package com.example.ex1_managementapartmentbuilding.controller.BillsController;

import com.example.ex1_managementapartmentbuilding.exception.NotFoundException;
import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.service.BillsService.BillService;
import com.example.ex1_managementapartmentbuilding.service.BillsService.ElectricBillService;
import com.example.ex1_managementapartmentbuilding.service.BillsService.InternetBillService;
import com.example.ex1_managementapartmentbuilding.service.BillsService.WaterBillService;
import com.example.ex1_managementapartmentbuilding.service.LeaseService;
import com.example.ex1_managementapartmentbuilding.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ElectricBillService electricBillService;

    @Autowired
    private WaterBillService waterBillService;

    @Autowired
    private InternetBillService internetBillService;

    @Autowired
    private LeaseService leaseService;

    @Autowired
    private SendMailService sendMailService;

    @GetMapping
    public ResponseEntity<?> getAllBill()
    {
        return ResponseEntity.ok().body(billService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBillById(@PathVariable Integer id)
    {
        checkObjectExist(id);
        return ResponseEntity.ok().body(billService.findBillById(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewBill(@RequestBody Bill bill,
                                           @RequestParam("electric_payment_id") Integer electric_bill_id,
                                           @RequestParam("water_payment_id") Integer water_payment_id,
                                           @RequestParam("internet_payment_id") Integer internet_payment_id,
                                           @RequestParam( value = "lease_id") Integer lease_id)
    {
        bill.setWaterPayment(waterBillService.findWaterPaymentById(water_payment_id));
        bill.setInternetPayment(internetBillService.findInternetPaymentById(internet_payment_id));
        bill.setElectricPayment(electricBillService.findElectricPaymentById(electric_bill_id));
        bill.setLease(leaseService.findLeaseById(lease_id));


        return ResponseEntity.ok().body(billService.create(bill));
    }


    @PatchMapping
    public ResponseEntity<?> updateBill(@RequestParam("bill_id") Integer id, @RequestBody Bill bill)
    {
        checkObjectExist(id);
        return ResponseEntity.ok().body(billService.update(id, bill));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBill(@RequestParam("bill_id") Integer id)
    {
        checkObjectExist(id);
        billService.delete(id);
        return ResponseEntity.ok().body("Object is deleted successfully");
    }

    private void checkObjectExist(int id)
    {
        if(billService.findBillById(id) == null)
        {
            throw new NotFoundException("Cannot find bill with id " + id);
        }
    }
}
