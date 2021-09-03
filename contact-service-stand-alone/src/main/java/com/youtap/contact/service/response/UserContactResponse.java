package com.youtap.contact.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContactResponse {
    private int id;
    private String email;
    private String phone;
}
