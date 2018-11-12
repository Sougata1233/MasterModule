package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.WarehouseDetailsDTO;
import com.example.master.services.serviceImpl.WarehouseDetailsServiceImpl;


@RestController
@RequestMapping("/warehouse/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class WarehouseDetailsController {

	@Autowired
	WarehouseDetailsServiceImpl warehouseService;
	
	
	@GetMapping("/getallwarehouses")
	public List<WarehouseDetailsDTO> getAllWarehouses(){
		return warehouseService.getAllWarehouseDetails();
	}
	
}
