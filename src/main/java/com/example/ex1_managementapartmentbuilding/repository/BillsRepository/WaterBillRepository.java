package com.example.ex1_managementapartmentbuilding.repository.BillsRepository;

import com.example.ex1_managementapartmentbuilding.model.Payments.WaterPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterBillRepository extends JpaRepository<WaterPayment, Integer> {

    WaterPayment findById(int id);
}
