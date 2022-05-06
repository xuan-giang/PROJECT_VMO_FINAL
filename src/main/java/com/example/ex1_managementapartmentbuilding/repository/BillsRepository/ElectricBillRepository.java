package com.example.ex1_managementapartmentbuilding.repository.BillsRepository;

import com.example.ex1_managementapartmentbuilding.model.Payments.ElectricPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricBillRepository extends JpaRepository<ElectricPayment, Integer> {

    ElectricPayment findById(int id);
}
