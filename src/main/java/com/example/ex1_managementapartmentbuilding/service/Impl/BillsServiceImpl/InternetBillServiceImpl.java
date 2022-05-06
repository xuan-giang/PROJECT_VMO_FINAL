package com.example.ex1_managementapartmentbuilding.service.Impl.BillsServiceImpl;

import com.example.ex1_managementapartmentbuilding.model.Payments.InternetPayment;
import com.example.ex1_managementapartmentbuilding.repository.BillsRepository.InternetBillRepository;
import com.example.ex1_managementapartmentbuilding.service.BillsService.InternetBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetBillServiceImpl implements InternetBillService {

    @Autowired
    private InternetBillRepository internetBillRepository;

    @Override
    public InternetPayment create(InternetPayment internetPayment) {
        return internetBillRepository.save(internetPayment);
    }

    @Override
    public InternetPayment update(int id, InternetPayment internetPayment) {
        InternetPayment updatedInternetPayment = internetBillRepository.findById(id);

        updatedInternetPayment.setFee(internetPayment.getFee());
        updatedInternetPayment.setStatus(internetPayment.getStatus());

        return internetBillRepository.save(updatedInternetPayment);
    }

    @Override
    public List<InternetPayment> findAll() {
        return internetBillRepository.findAll();
    }

    @Override
    public InternetPayment findInternetPaymentById(int id) {
        return internetBillRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        internetBillRepository.deleteById(id);
    }
}
