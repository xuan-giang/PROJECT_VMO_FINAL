package com.example.ex1_managementapartmentbuilding.model.Payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaterPayment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "water_payment_id")
    private Integer id;

    private Integer fee;

    private Integer status;

    private int previousNumber;

    private int nextNumber;

    public void caculateFee()
    {
        this.fee = this.nextNumber - this.previousNumber;
    }
}
