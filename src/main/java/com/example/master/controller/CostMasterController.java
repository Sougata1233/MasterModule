package com.example.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.entity.CostMaster;
import com.example.master.services.CostMasterService;

@RestController
@RequestMapping("/costmaster")
public class CostMasterController {
	
	@Autowired
	CostMasterService costService;
	
	@GetMapping("/getAllCostMaster")
	public List<CostMaster> getAllCostMaster(){
		return costService.getAllCostMaster();
	}

}
