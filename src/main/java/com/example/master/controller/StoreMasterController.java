package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.StoreMasterDTO;
import com.example.master.services.serviceImpl.StoreMasterServiceImpl;


@RestController
@RequestMapping("/storemaster/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class StoreMasterController {

	@Autowired
	StoreMasterServiceImpl storeService;
	
	@GetMapping("getallstoremaster")
	public List<StoreMasterDTO> getAllStoreMaster() {
		return storeService.getAllStoreMaster();
	}
	
}
