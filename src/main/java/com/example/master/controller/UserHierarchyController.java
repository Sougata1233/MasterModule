package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.UserHierDTO.GroupHeadDTO;
import com.example.master.services.serviceImpl.UserHierarcyServiceImpl;

/*
 * 
 * SRestController class for User Hierarchy
 * 
 */
@RestController
@RequestMapping("/easybusiness/userhierarcy/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class UserHierarchyController {
	
	@Autowired
	UserHierarcyServiceImpl hierarchyService;
	
	@GetMapping("getAllHierarchy")
	public List<GroupHeadDTO> populateHierarcyList(){
		return hierarchyService.hierarchy();
	}
	
	@GetMapping("getAllHierarchy/{userId}")
	public List<GroupHeadDTO> hierarchyByUser(@PathVariable("userId") long userId){
		return hierarchyService.hierarchyByUser(userId);
	}

}
