package com.youtap.contact.service.util;

import lombok.Data;

@Data
public class GenericApiError {
    private String status;
    private String error;

    public GenericApiError(String error) {
        super();
        this.status = "failed";
        this.error = error;
    }
}
