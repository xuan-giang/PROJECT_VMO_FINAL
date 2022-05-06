package com.example.ex1_managementapartmentbuilding.model.Payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ElectricPayment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "electric_payment_id")
    private Integer id;

    private Integer fee;

    private int status;

    private int previousNumber;

    private int nextNumber;

    public void caculateFee()
    {
        this.fee = this.nextNumber - this.previousNumber;
    }
}
