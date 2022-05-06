package com.example.ex1_managementapartmentbuilding.repository.BillsRepository;

import com.example.ex1_managementapartmentbuilding.model.Payments.InternetPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetBillRepository extends JpaRepository<InternetPayment, Integer> {

    InternetPayment findById(int id);
}
