package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Invoice;
import com.bezkoder.spring.datajpa.repository.InvoiceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRespository invoiceRespository;



    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> searchInvoice(@RequestParam(required = false) Integer invoiceId){
        List<Invoice> invoiceList = invoiceRespository.findAll();
        return new ResponseEntity<>(invoiceList, HttpStatus.OK);
    }
}
