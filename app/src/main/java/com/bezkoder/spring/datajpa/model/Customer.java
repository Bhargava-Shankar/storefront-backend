package com.bezkoder.spring.datajpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customer_id_seq")
    private Integer customerId;
    private String customerName;
}
