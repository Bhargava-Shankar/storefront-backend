package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine,Integer> {
}
