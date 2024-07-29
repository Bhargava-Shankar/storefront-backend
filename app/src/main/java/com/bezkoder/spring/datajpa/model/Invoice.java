package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @SequenceGenerator(name = "invoice_id_seq", sequenceName = "invoice_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "invoice_id_seq")
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    // [ { product_id1,qty1 }, { product_id2,qty2 } ]

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceLine> invoiceLineList;

    public Double totalAmount;

    public Timestamp createdAt;



}
