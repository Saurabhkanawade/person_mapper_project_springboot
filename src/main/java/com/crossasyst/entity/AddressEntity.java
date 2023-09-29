package com.crossasyst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;
    private String address;
    private String city;
    private String state;
    private Long zipcode;
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
    private PersonEntity person;
}
