package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.UserHierDTO.ParentOrgDTO;
import com.example.master.dto.UserHierDTO.UserHierarcyDTO;
import com.example.master.services.serviceImpl.OrgHierarcyServiceImpl;

/*
 * Service and RestController class for UserHierarchy
 */
@RestController
@RequestMapping("/orghierarcy/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class OrgHierarchyController {
	
	@Autowired 
	OrgHierarcyServiceImpl orghierarchyService;
	
	@GetMapping("getByOrgHierarcyId/{hierarcyId}")
	public ResponseEntity<UserHierarcyDTO> getHierarcyById(@PathVariable("hierarcyId") Long hierarcyId){
		return orghierarchyService.getHierarcyById(hierarcyId);
	}
	
	@GetMapping("getAllOrgHierarcy")
	public List<UserHierarcyDTO> populateHierarcyList(){
		return orghierarchyService.populateHierarcyList();
	}
	
	@GetMapping("getGroupHeadOrgHierarchy")
	public ParentOrgDTO groupHead() {
		return orghierarchyService.groupHead();
	}

}
