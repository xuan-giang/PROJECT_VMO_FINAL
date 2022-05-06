package com.example.ex1_managementapartmentbuilding.service.Impl.BillsServiceImpl;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.repository.BillsRepository.BillRepository;
import com.example.ex1_managementapartmentbuilding.service.BillsService.BillService;
import com.example.ex1_managementapartmentbuilding.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private SendMailService sendMailService;

    @Override
    public Bill create(Bill bill) {
        if(isComplete(bill))
        {
            bill.setStatus(1);
            bill.setTotal(getTotalBill(bill));
        }else {
            bill.setStatus(0);
            bill.setTotal(0);
        }
        sendMailToUser(bill);
        reminderPaid();
        return billRepository.save(bill);
    }

    // Check status 3 bills (Water - Internet - Electric)
    private boolean isComplete(Bill bill)
    {
        return bill.getElectricPayment().getStatus() == 1 && bill.getInternetPayment().getStatus() == 1 && bill.getWaterPayment().getStatus() == 1;
    }

    // Get sum fee of 3 bills
    private int getTotalBill(Bill bill)
    {
        return bill.getElectricPayment().getFee() + bill.getWaterPayment().getFee() + bill.getInternetPayment().getFee();
    }

    @Override
    public Bill update(int id, Bill bill) {
        Bill updatedBill = billRepository.findById(id);

        updatedBill.setStatus(bill.getStatus());
        updatedBill.setUpdatedAt(bill.getUpdatedAt());
        updatedBill.setTotal(bill.getTotal());
        updatedBill.setInternetPayment(bill.getInternetPayment());
        updatedBill.setWaterPayment(bill.getWaterPayment());
        updatedBill.setElectricPayment(bill.getElectricPayment());
        updatedBill.setDateBill(bill.getDateBill());
        updatedBill.setLease(bill.getLease());
        updatedBill.setCreatedAt(bill.getCreatedAt());

        return billRepository.save(updatedBill);
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill findBillById(int id) {
        return billRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        billRepository.deleteById(id);
    }

    private void sendMailToUser(Bill bill)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println("Test: " + timeStamp);
        sendMailService.sendMailWithText(timeStamp + "[#ROOM_" +bill.getLease().getApartment().getName() + "] THÔNG BÁO HOÁ ĐƠN CẦN THANH TOÁN ",
                sendMailService.getContentMail(bill),
                bill.getLease().getTenant().getEmail());
    }

    //@Scheduled(cron = "0 * * * * *") // Run every minutes
    @Scheduled(cron = "0 15 10 ? * 6L") // Run at 10:15 on the last Friday of the month
    private void reminderPaid()
    {
        List<Bill> billList = billRepository.findAll();
        for(Bill bill : billList)
        {
            if(bill.getStatus() == 0)
            {
                sendMailToUser(bill);
            }
        }
    }
}
