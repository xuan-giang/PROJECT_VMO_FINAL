package com.example.ex1_managementapartmentbuilding.service.BillsService;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.model.Payments.ElectricPayment;

import java.util.List;

public interface ElectricBillService {
    ElectricPayment create(ElectricPayment electricPayment);

    ElectricPayment update(int id, ElectricPayment electricPayment);

    List<ElectricPayment> findAll();

    ElectricPayment findElectricPaymentById(int id);

    void delete(int id);
}
