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

import com.example.master.dto.DeleteDTO;
import com.example.master.dto.RoleDetailsDTO;
import com.example.master.entity.RoleDetails;
import com.example.master.services.RoleDetailsService;
import com.example.master.services.serviceImpl.RoleDetailsServiceImpl;


@RestController
@RequestMapping("/roledetails/")
public class RoleDetailsController implements RoleDetailsService {

    @Autowired
    RoleDetailsServiceImpl roledetailsService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addRoleDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RoleDetailsDTO> persistRoleDetails(@RequestBody RoleDetailsDTO roledetailsDTO) {

    	roledetailsService.persistRoleDetails(roledetailsDTO);
    	
	return new ResponseEntity<RoleDetailsDTO>(roledetailsDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateRoleDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RoleDetailsDTO> updateRoleDetails(@RequestBody RoleDetailsDTO roledetailsDTO) {

    	roledetailsService.updateRoleDetails(roledetailsDTO);
    	
	return new ResponseEntity<RoleDetailsDTO>(roledetailsDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllRoleDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDetailsDTO> populateRoleDetailsList() {
	
    	return roledetailsService.populateRoleDetailsList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getRoleDetailsById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public RoleDetailsDTO populateOneRoleDetailsDetails(@PathVariable("Id") Long Id) {
    
    	return roledetailsService.populateOneRoleDetailsDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteRoleDetails/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyRoleDetails(@PathVariable("Id") Long Id) {

    	roledetailsService.destroyRoleDetails(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
