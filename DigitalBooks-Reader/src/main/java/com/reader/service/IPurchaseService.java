package com.reader.service;

import java.util.List;

import com.reader.model.Purchase;

public interface IPurchaseService {

	public List<Purchase> savePurchaseItems(List<Purchase> p);
	
}
