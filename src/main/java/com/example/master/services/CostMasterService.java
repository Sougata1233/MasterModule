package com.example.master.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.master.entity.CostMaster;

@Service
public interface CostMasterService {
	
	public List<CostMaster> getAllCostMaster();

}
