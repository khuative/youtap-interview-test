package com.youtap.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/contactServiceFallBack")
    public String userServiceFallBackMethod() {
        return "Contact Service is taking longer than Expected." +
                " Please try again later";
    }
}
