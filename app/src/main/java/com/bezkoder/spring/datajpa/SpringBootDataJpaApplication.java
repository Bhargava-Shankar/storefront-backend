package com.bezkoder.spring.datajpa;

import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.repository.CustomerRepository;
import com.bezkoder.spring.datajpa.repository.InvoiceLineRepository;
import com.bezkoder.spring.datajpa.repository.InvoiceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	InvoiceRespository invoiceRespository;
	@Autowired
	InvoiceLineRepository invoiceLineRepository;
	@PostConstruct
	public void init(){
		Customer customer = new Customer();
		customer.setCustomerName("Bhargava");
		System.out.println("New Record Created");
		customerRepository.save(customer);

//		invoiceRespository.deleteAll();
//		invoiceLineRepository.deleteAll();
	}

}
