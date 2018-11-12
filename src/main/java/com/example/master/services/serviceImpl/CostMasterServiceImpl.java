package com.example.master.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.CostMasterDao;
import com.example.master.entity.CostMaster;
import com.example.master.services.CostMasterService;

@Service
public class CostMasterServiceImpl implements CostMasterService {
	
	@Autowired
	CostMasterDao costDao;

	@Override
	public List<CostMaster> getAllCostMaster() {
		return costDao.getAllCostMaster();
	}

}
