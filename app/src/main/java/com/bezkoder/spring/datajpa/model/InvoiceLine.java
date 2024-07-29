package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

@Entity
public class InvoiceLine {

    @Id
    private Integer invoiceLineId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Integer invoiceQty;

    private Integer invoicePrice;

    @ManyToOne
    @JoinColumn(name="invoiceId")
    private Invoice invoice;

}
