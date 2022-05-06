package com.example.ex1_managementapartmentbuilding.service.Impl.BillsServiceImpl;

import com.example.ex1_managementapartmentbuilding.model.Payments.ElectricPayment;
import com.example.ex1_managementapartmentbuilding.repository.BillsRepository.ElectricBillRepository;
import com.example.ex1_managementapartmentbuilding.service.BillsService.ElectricBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricBillServiceImpl implements ElectricBillService {

    @Autowired
    private ElectricBillRepository electricBillRepository;

    @Override
    public ElectricPayment create(ElectricPayment electricPayment) {
        return electricBillRepository.save(electricPayment);
    }

    @Override
    public ElectricPayment update(int id, ElectricPayment electricPayment) {
        ElectricPayment updatedElectricPayment = electricBillRepository.findById(id);

        updatedElectricPayment.setFee(electricPayment.getFee());
        updatedElectricPayment.setNextNumber(electricPayment.getNextNumber());
        updatedElectricPayment.setPreviousNumber(electricPayment.getPreviousNumber());
        updatedElectricPayment.setStatus(electricPayment.getStatus());

        return electricBillRepository.save(updatedElectricPayment);
    }

    @Override
    public List<ElectricPayment> findAll() {
        return electricBillRepository.findAll();
    }

    @Override
    public ElectricPayment findElectricPaymentById(int id) {
        return electricBillRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        electricBillRepository.deleteById(id);
    }
}
