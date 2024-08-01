package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Invoice;
import com.bezkoder.spring.datajpa.model.InvoiceLine;
import com.bezkoder.spring.datajpa.model.Product;
import com.bezkoder.spring.datajpa.repository.InvoiceLineRepository;
import com.bezkoder.spring.datajpa.repository.InvoiceRespository;
import com.bezkoder.spring.datajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRespository invoiceRespository;

    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> searchInvoice(@RequestParam(required = false) Integer invoiceId){
        List<Invoice> invoiceList = invoiceRespository.findAll();
        return new ResponseEntity<>(invoiceList, HttpStatus.OK);
    }

    @PostMapping("/invoices")
    public ResponseEntity<String> createInvoice(@RequestBody(required = false) Invoice invoice){
        //CREATE RECORD IN INVOICE AND INVOICE LINE
        Invoice invoiceNew = invoiceRespository.save(invoice);
        System.out.println(invoiceNew);
        for(InvoiceLine invoiceLine : invoice.getInvoiceLineList()){
            invoiceLine.setInvoice(invoiceNew);
            invoiceLineRepository.save(invoiceLine);
            Product productToUpdate = productRepository.findById(invoiceLine.getProductId()).get();
            if(productToUpdate.getProductQty() > 0){
                productToUpdate.setProductQty(productToUpdate.getProductQty() - invoiceLine.getInvoiceLineQty());
                productRepository.save(productToUpdate);
            }
            else{
                return new ResponseEntity<>("Product Quantity Not Available",HttpStatus.CONFLICT);
            }

        }
        //SUBTRACT TOTAL QUANTITY FROM PRODUCT DATABASE


//        invoiceRespository.save(invoice);
        return new ResponseEntity<>("Invoice Created",HttpStatus.OK);
    }
}
