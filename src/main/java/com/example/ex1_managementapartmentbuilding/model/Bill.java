package com.example.ex1_managementapartmentbuilding.model;

import com.example.ex1_managementapartmentbuilding.model.Payments.ElectricPayment;
import com.example.ex1_managementapartmentbuilding.model.Payments.InternetPayment;
import com.example.ex1_managementapartmentbuilding.model.Payments.WaterPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer id;

    private Date dateBill;

    @OneToOne
    @JoinColumn(name = "electric_payment_id")
    private ElectricPayment electricPayment;


    @OneToOne
    @JoinColumn(name = "water_payment_id")
    private WaterPayment waterPayment;

    @OneToOne
    @JoinColumn(name = "internet_payment_id")
    private InternetPayment internetPayment;

    private Integer total;

    private int status;

    @Column(name = "`created_at`")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    private Lease lease;

    public Integer getTotal()
    {
        return this.electricPayment.getFee() + this.getWaterPayment().getFee() + this.getInternetPayment().getFee();
    }
}
