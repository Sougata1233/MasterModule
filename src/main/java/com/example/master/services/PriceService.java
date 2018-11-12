package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.master.dto.DeleteDTO;
import com.example.master.dto.PriceDTO;

public interface PriceService {
	
	public ResponseEntity<PriceDTO> addPrice(PriceDTO price);
	public PriceDTO getPriceById(long priceId);
	public List<PriceDTO> getAllPrices();
	public DeleteDTO deletePrice(long priceId);
	public ResponseEntity<PriceDTO> updatePrice(PriceDTO priceDTO);

}
