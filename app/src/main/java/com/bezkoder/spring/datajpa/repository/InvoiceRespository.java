package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRespository extends JpaRepository<Invoice,Integer> {

}
