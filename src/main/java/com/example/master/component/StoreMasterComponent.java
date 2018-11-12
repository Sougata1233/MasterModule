package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.StoreMaster;
import com.example.master.repository.StoreMasterReposiotory;

@Component
public class StoreMasterComponent {

	@Autowired
	StoreMasterReposiotory storeRepository;
	
	@Transactional
	public List<StoreMaster> getAllStoreMaster(){
		return storeRepository.findAll();
	}
	
}
