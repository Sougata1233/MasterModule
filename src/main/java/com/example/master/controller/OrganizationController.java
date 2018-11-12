package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.component.OrganizationDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.EmployeeDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.entity.Department;
import com.example.master.entity.Employee;
import com.example.master.entity.Organization;
import com.example.master.services.OrganizationService;
import com.example.master.services.serviceImpl.OrganizationServiceImpl;

@RestController
@RequestMapping("/organization/")
public class OrganizationController implements OrganizationService {

    @Autowired
    OrganizationServiceImpl organizationService;
    
    @Autowired
    OrganizationDao orgDao;

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addOrganization", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrganizationDTO> persistUser(@RequestBody OrganizationDTO organizationDTO) {

    	Organization org = orgDao.getAllOrganizationsByName(organizationDTO.getorgName().toUpperCase());
    	
    	if(org == null) {
    		organizationService.persistUser(organizationDTO);
    		return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.CREATED);
    	}else {
    		return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.ALREADY_REPORTED);
    	}
    	
    	
	

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateOrganization", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrganizationDTO> updateOrganization(@RequestBody OrganizationDTO organizationDTO) {

    	organizationService.updateOrganization(organizationDTO);
    	
	return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllOrganization", method = RequestMethod.GET)
    @ResponseBody
    public List<OrganizationDTO> populateOrganizationList() {
	
    	return organizationService.populateOrganizationList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getOrganizationById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public OrganizationDTO populateOneOrganizationDetails(@PathVariable("Id") Long Id) {
    	
    	return organizationService.populateOneOrganizationDetails(Id);
	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteOrganization/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyOrganization(@PathVariable("Id") Long Id) {
    	return organizationService.destroyOrganization(Id);
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllHeadOrganizations", method = RequestMethod.GET)
    @ResponseBody
	public List<OrganizationDTO> getAllHeadOrganization() {
		return organizationService.getAllHeadOrganization();
	}

   
    

    
}
