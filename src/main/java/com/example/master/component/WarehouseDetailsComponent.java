package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.WarehouseDetails;
import com.example.master.repository.WarehouseDetailsRepository;

@Component
public class WarehouseDetailsComponent {

	@Autowired
	WarehouseDetailsRepository  warehouseRepository;
	
	
	@Transactional
	public List<WarehouseDetails> getAllWarehouseDetails(){
		return warehouseRepository.findAll();
	}
	
}
