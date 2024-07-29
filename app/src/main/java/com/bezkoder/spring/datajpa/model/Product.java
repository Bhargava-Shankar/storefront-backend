package com.bezkoder.spring.datajpa.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DynamicInsert
@DynamicUpdate
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq",  allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_id_seq")
    private Integer productId;

    private String productName;

    private Integer productQty;

    private Integer productPrice;


}
