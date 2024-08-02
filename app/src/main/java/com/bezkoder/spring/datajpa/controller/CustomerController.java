package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(@PathVariable(required = false) Integer customerId){
        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable(required = false) Integer id){
        Customer customer = customerRepository.findById(id).get();
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        Customer customer1 = customerRepository.save(customer);
        return new ResponseEntity<>("Customer Created",HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
         try{
             Customer existingCustomer = customerRepository.findById(id).get();
             existingCustomer.setCustomerName(customer.getCustomerName());
             customerRepository.save(existingCustomer);
             return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
         }
         catch(Exception e){
             return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(required = true) Integer id){
        try{ customerRepository.deleteById(id); } catch(Exception ignore) {};
        return new ResponseEntity<>("Customer Deleted",HttpStatus.NO_CONTENT);
    }

}
