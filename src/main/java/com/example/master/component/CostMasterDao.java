package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.CostMaster;
import com.example.master.repository.CostMasterRepository;

@Component
public class CostMasterDao {
	
	@Autowired
	CostMasterRepository costmasterRepository;
	
	@Transactional
	public List<CostMaster> getAllCostMaster(){
		return costmasterRepository.findAll();
	}

}
