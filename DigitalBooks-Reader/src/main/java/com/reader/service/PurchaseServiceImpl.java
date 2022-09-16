package com.reader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.model.Purchase;

@Service
public class PurchaseServiceImpl implements IPurchaseService{
	
	@Autowired
	IPurchaseRepository repo;
	
	@Override
	public List<Purchase> savePurchaseItems(List<Purchase> purchase) {
		
		List<Purchase> savedBook = repo.saveAll(purchase);
		return savedBook;
		
	}

}
