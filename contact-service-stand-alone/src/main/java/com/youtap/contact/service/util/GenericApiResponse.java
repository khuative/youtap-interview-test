package com.youtap.contact.service.util;

import lombok.Data;

@Data
public class GenericApiResponse {
    private String status;
    private String message;

    public GenericApiResponse(String message) {
        super();
        this.status = "success";
        this.message = message;
    }
}
