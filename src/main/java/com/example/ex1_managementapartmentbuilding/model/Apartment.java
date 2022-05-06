package com.example.ex1_managementapartmentbuilding.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Apartment {

    @Id
    @Column(name = "apartment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double size;

    private String type;

    private int amount_room;

    private int status;

    public Apartment(String name, Double size, String type, int amount_room) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.amount_room = amount_room;
    }
//    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    private List<Lease> leases;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
