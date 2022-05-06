package com.example.ex1_managementapartmentbuilding.service.BillsService;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.model.Payments.WaterPayment;

import java.util.List;

public interface WaterBillService {
    WaterPayment create(WaterPayment waterPayment);

    WaterPayment update(int id, WaterPayment waterPayment);

    List<WaterPayment> findAll();

    WaterPayment findWaterPaymentById(int id);

    void delete(int id);
}
