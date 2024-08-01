package com.bezkoder.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InvoiceLine {

    @Id
    @SequenceGenerator(name = "invoiceLine_id_seq", sequenceName = "invoiceLine_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "invoiceLine_id_seq")
    private Integer invoiceLineId;

    private Integer productId;

    private Integer invoiceLineQty;

    private Integer invoiceLinePerUnitPrice;
    private Integer invoiceLineTotalPrice;

    @ManyToOne
    @JoinColumn(name="invoiceId")
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"invoiceLineList"})
    private Invoice invoice;

}
