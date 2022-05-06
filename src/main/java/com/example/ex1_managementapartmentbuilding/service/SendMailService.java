package com.example.ex1_managementapartmentbuilding.service;

import com.example.ex1_managementapartmentbuilding.model.Bill;

public interface SendMailService {
    String sendMailWithText(String sub, String content, String to);

    public String getContentMail(Bill bill);


}
