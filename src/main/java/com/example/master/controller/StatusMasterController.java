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
import com.example.master.dto.StatusMasterDTO;
import com.example.master.entity.StatusMaster;
import com.example.master.services.StatusMasterService;
import com.example.master.services.serviceImpl.StatusMasterServiceImpl;


@RestController
@RequestMapping("/statusMaster/")
public class StatusMasterController implements StatusMasterService {

    @Autowired
    StatusMasterServiceImpl statusmasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addStatusMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StatusMasterDTO> persistStatusMaster(@RequestBody StatusMasterDTO statusmasterDTO) {

    	statusmasterService.persistStatusMaster(statusmasterDTO);
    	
	return new ResponseEntity<StatusMasterDTO>(statusmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateStatusMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StatusMasterDTO> updateStatusMaster(@RequestBody StatusMasterDTO statusmasterDTO) {

    	statusmasterService.updateStatusMaster(statusmasterDTO);
    	
	return new ResponseEntity<StatusMasterDTO>(statusmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllStatusMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<StatusMasterDTO> populateStatusMasterList() {
	
    	return statusmasterService.populateStatusMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getStatusMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public StatusMasterDTO populateOneStatusMasterDetails(@PathVariable("Id") Long Id) {
    
    	return statusmasterService.populateOneStatusMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteStatusMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyStatusMaster(@PathVariable("Id") Long Id) {

    	statusmasterService.destroyStatusMaster(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
