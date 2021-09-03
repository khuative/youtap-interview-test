package com.youtap.contact.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyUserResponse {
    private int id;
    private String name;
    private String username;
    private String email;
    private UserAddressResponse address;
    private String phone;
    private String website;
    private UserCompanyResponse company;
}

