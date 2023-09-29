package com.crossasyst.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressRequest {

    private String address;
    private String city;
    private String state;
    private Long zipcode;
}
