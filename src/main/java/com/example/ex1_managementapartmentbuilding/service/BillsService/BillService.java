package com.example.ex1_managementapartmentbuilding.service.BillsService;

import com.example.ex1_managementapartmentbuilding.model.Bill;

import java.util.List;

public interface BillService {

    Bill create(Bill bill);

    Bill update(int id, Bill bill);

    List<Bill> findAll();

    Bill findBillById(int id);

    void delete(int id);
}
