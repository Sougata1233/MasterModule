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
import com.example.master.dto.LeaveMasterDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.LeaveMaster;
import com.example.master.services.LeaveMasterService;
import com.example.master.services.serviceImpl.LeaveMasterServiceImpl;


@RestController
@RequestMapping("/leaveMaster/")
public class LeaveMasterController implements LeaveMasterService {

    @Autowired
    LeaveMasterServiceImpl leavemasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addLeaveMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<LeaveMasterDTO> persistLeaveMaster(@RequestBody LeaveMasterDTO leavemasterDTO) {

    	leavemasterService.persistLeaveMaster(leavemasterDTO);
    	
	return new ResponseEntity<LeaveMasterDTO>(leavemasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateLeaveMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<LeaveMasterDTO> updateLeaveMaster(@RequestBody LeaveMasterDTO leavemasterDTO) {

    	leavemasterService.updateLeaveMaster(leavemasterDTO);
    	
	return new ResponseEntity<LeaveMasterDTO>(leavemasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllLeaveMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<LeaveMasterDTO> populateLeaveMasterList() {
	
    	return leavemasterService.populateLeaveMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByLeaveMasterId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public LeaveMasterDTO populateOneLeaveMasterDetails(@PathVariable("userId") Long userId) {
    
    	return leavemasterService.populateOneLeaveMasterDetails(userId);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteLeaveMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyLeaveMaster(@PathVariable("Id") Long Id) {

    	leavemasterService.destroyLeaveMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
