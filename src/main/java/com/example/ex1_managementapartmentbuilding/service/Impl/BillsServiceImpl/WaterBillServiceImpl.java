package com.example.ex1_managementapartmentbuilding.service.Impl.BillsServiceImpl;

import com.example.ex1_managementapartmentbuilding.model.Payments.WaterPayment;
import com.example.ex1_managementapartmentbuilding.repository.BillsRepository.WaterBillRepository;
import com.example.ex1_managementapartmentbuilding.service.BillsService.WaterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterBillServiceImpl implements WaterBillService{

    @Autowired
    private WaterBillRepository waterBillRepository;

    @Override
    public WaterPayment create(WaterPayment waterPayment) {
        return waterBillRepository.save(waterPayment);
    }

    @Override
    public WaterPayment update(int id, WaterPayment waterPayment) {
        WaterPayment updatedWaterPayment = waterBillRepository.findById(id);

        updatedWaterPayment.setFee(waterPayment.getFee());
        updatedWaterPayment.setNextNumber(waterPayment.getNextNumber());
        updatedWaterPayment.setStatus(waterPayment.getStatus());
        updatedWaterPayment.setPreviousNumber(waterPayment.getPreviousNumber());

        return waterBillRepository.save(updatedWaterPayment);
    }

    @Override
    public List<WaterPayment> findAll() {
        return waterBillRepository.findAll();
    }

    @Override
    public WaterPayment findWaterPaymentById(int id) {
        return waterBillRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        waterBillRepository.deleteById(id);
    }
}
