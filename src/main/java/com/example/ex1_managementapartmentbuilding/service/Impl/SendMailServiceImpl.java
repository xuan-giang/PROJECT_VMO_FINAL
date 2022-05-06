package com.example.ex1_managementapartmentbuilding.service.Impl;

import com.example.ex1_managementapartmentbuilding.model.Bill;
import com.example.ex1_managementapartmentbuilding.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMailWithText(String sub, String content, String to) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setSubject(sub);
            simpleMailMessage.setText(content);
            simpleMailMessage.setTo(to);

            javaMailSender.send(simpleMailMessage);
        }catch (Exception e) {
            return "Send failed";
        }

        return "Send successfully";
    }

    @Override
    public String getContentMail(Bill bill)
    {
        return
                "PHÍ DỊCH VỤ CĂN HỘ " + bill.getLease().getApartment().getName() +
                        "\nTên chủ hộ: " + bill.getLease().getTenant().getFullName() +
                "\nNội dung cần thanh toán: \n" +
                        "\n- Giá điện: " + bill.getElectricPayment().getFee() + " VND (Số cũ: " + bill.getElectricPayment().getPreviousNumber() + " - Số mới: " + bill.getElectricPayment().getNextNumber() + ")" +
                        "\n- Giá nước sạch: " + bill.getWaterPayment().getFee() + " VND (Số cũ: " + bill.getWaterPayment().getPreviousNumber() + " - Số mới: " + bill.getWaterPayment().getNextNumber() + ")" +
                        "\n- Giá Internet: " + bill.getInternetPayment().getFee() + " VND" +
                        "\n=> TỔNG CỘNG: " + bill.getTotal() + " VND"
                ;
    }


}
