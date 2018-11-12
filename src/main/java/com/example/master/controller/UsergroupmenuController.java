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
import com.example.master.dto.UsergroupmenuDTO;
import com.example.master.entity.Usergroupmenu;
import com.example.master.services.UsergroupmenuService;
import com.example.master.services.serviceImpl.UsergroupmenuServiceImpl;


@RestController
@RequestMapping("/usergroupmenu/")
public class UsergroupmenuController implements UsergroupmenuService {

    @Autowired
    UsergroupmenuServiceImpl usergroupmenuService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addUsergroupmenu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsergroupmenuDTO> persistUsergroupmenu(@RequestBody UsergroupmenuDTO usergroupmenuDTO) {

    	usergroupmenuService.persistUsergroupmenu(usergroupmenuDTO);
    	
	return new ResponseEntity<UsergroupmenuDTO>(usergroupmenuDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateUsergroupmenu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsergroupmenuDTO> updateUsergroupmenu(@RequestBody UsergroupmenuDTO usergroupmenuDTO) {

    	usergroupmenuService.updateUsergroupmenu(usergroupmenuDTO);
    	
	return new ResponseEntity<UsergroupmenuDTO>(usergroupmenuDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllUsergroupmenu", method = RequestMethod.GET)
    @ResponseBody
    public List<UsergroupmenuDTO> populateUsergroupmenuList() {
	
    	return usergroupmenuService.populateUsergroupmenuList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByUsergroupmenuId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UsergroupmenuDTO populateOneUsergroupmenuDetails(@PathVariable("userId") Long userId) {
    
    	return usergroupmenuService.populateOneUsergroupmenuDetails(userId);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteUsergroupmenu/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyUsergroupmenu(@PathVariable("userId") Long userId) {

    	usergroupmenuService.destroyUsergroupmenu(userId);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
