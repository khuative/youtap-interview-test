package com.youtap.contact.service.controller;

import com.youtap.contact.service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("getusercontacts/{query}")
    public ResponseEntity getUserContactByIdOrUsername(@PathVariable("query") String query) {
        return contactService.getUserContactByIdOrUsername(query);
    }
}
