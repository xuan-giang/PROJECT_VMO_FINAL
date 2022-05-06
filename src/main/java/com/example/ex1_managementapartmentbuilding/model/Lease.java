package com.example.ex1_managementapartmentbuilding.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat
    private Timestamp startDate;

    @DateTimeFormat
    private Timestamp endDate;

    private String deposit;

    private int status;

    @OneToOne
    private Tenant tenant;

//    @OneToMany(mappedBy = "lease", cascade = CascadeType.ALL)
//    private Set<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
}
