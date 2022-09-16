package com.reader.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reader.model.Purchase;

public interface IPurchaseRepository extends JpaRepository<Purchase, Integer>{

}
