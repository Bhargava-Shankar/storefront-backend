package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customer_id_seq")
    private Integer customerId;
    private String customerName;
}
