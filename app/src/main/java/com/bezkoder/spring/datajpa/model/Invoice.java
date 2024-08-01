package com.bezkoder.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Invoice {

    @Id
    @SequenceGenerator(name = "invoice_id_seq", sequenceName = "invoice_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "invoice_id_seq")
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"invoice"})
    private List<InvoiceLine> invoiceLineList;

    public Double invoiceTotalQty;
    public Double invoiceTotalAmount;


    @CreationTimestamp
    public Timestamp createdAt;

    @Override
    public String toString() {
        return "Invoice{" +
                ", invoiceLineList size=" + invoiceLineList.size() +
                ", invoiceTotalQty=" + invoiceTotalQty +
                ", invoiceTotalAmount=" + invoiceTotalAmount +
                ", createdAt=" + createdAt +
                '}';
    }


}
