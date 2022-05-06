package com.example.ex1_managementapartmentbuilding.service.BillsService;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.model.Payments.InternetPayment;

import java.util.List;

public interface InternetBillService {
    InternetPayment create(InternetPayment internetPayment);

    InternetPayment update(int id, InternetPayment internetPayment);

    List<InternetPayment> findAll();

    InternetPayment findInternetPaymentById(int id);

    void delete(int id);
}
