package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.Price;
import com.example.master.repository.PriceRepository;

@Component
public class PriceDao {
	
	@Autowired
	PriceRepository priceRepository;
	
	@Transactional
	public List<Price> getAllPrice(){
		return priceRepository.findAll();
	}
	
	@Transactional
	public Price getPriceById(long priceId) {
		return priceRepository.findOne(priceId);
	}
	
	@Transactional
	public void save(Price price) {
		priceRepository.save(price);
	}
	
	@Transactional
	public void delete(long priceId) {
		priceRepository.delete(priceId);
	}

}
