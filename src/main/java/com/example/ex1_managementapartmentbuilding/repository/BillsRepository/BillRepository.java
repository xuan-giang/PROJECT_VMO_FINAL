package com.example.ex1_managementapartmentbuilding.repository.BillsRepository;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    Bill findById(int id);
}
