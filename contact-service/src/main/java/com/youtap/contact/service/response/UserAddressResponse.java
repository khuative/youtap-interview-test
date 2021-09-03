package com.youtap.contact.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressResponse {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserGeoResponse geo;
}
