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
import com.example.master.dto.UsergroupDTO;
import com.example.master.entity.Usergroup;
import com.example.master.services.UsergroupService;
import com.example.master.services.serviceImpl.UsergroupServiceImpl;


@RestController
@RequestMapping("/usergroup/")
public class UsergroupController implements UsergroupService {

    @Autowired
    UsergroupServiceImpl usergroupService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addUsergroup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsergroupDTO> persistUsergroup(@RequestBody UsergroupDTO usergroupDTO) {

    	usergroupService.persistUsergroup(usergroupDTO);
    	
	return new ResponseEntity<UsergroupDTO>(usergroupDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateUsergroup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsergroupDTO> updateUsergroup(@RequestBody UsergroupDTO usergroupDTO) {

    	usergroupService.updateUsergroup(usergroupDTO);
    	
	return new ResponseEntity<UsergroupDTO>(usergroupDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllUsergroup", method = RequestMethod.GET)
    @ResponseBody
    public List<UsergroupDTO> populateUsergroupList() {
	
    	return usergroupService.populateUsergroupList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByUsergroupId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UsergroupDTO populateOneUsergroupDetails(@PathVariable("userId") Long userId) {
    
    	return usergroupService.populateOneUsergroupDetails(userId);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteUsergroup/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyUsergroup(@PathVariable("userId") Long userId) {

    	usergroupService.destroyUsergroup(userId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
