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

import com.example.master.dto.ApproverMasterDTO;
import com.example.master.dto.UsergroupDTO;
import com.example.master.entity.ApproverMaster;
import com.example.master.services.ApproverMasterService;
import com.example.master.services.serviceImpl.ApproverMasterServiceImpl;


@RestController
@RequestMapping("/approvermaster/")
public class ApproverMasterController implements ApproverMasterService {

    @Autowired
    ApproverMasterServiceImpl approvermasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addApproverMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApproverMasterDTO> persistApproverMaster(@RequestBody ApproverMasterDTO approvermasterDTO) {

	
    	approvermasterService.persistApproverMaster(approvermasterDTO);
    	
		return new ResponseEntity<ApproverMasterDTO>(approvermasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateApproverMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApproverMasterDTO> updateApproverMaster(@RequestBody ApproverMasterDTO approvermasterDTO) {

	approvermasterService.updateApproverMaster(approvermasterDTO);
	return new ResponseEntity<ApproverMasterDTO>(approvermasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllApproverMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<ApproverMasterDTO> populateApproverMasterList() {
	
	return approvermasterService.populateApproverMasterList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getApproverMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public ApproverMasterDTO populateOneApproverMasterDetails(@PathVariable("Id") Long Id) {
    	
	return approvermasterService.populateOneApproverMasterDetails(Id);
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteApproverMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void destroyApproverMaster(@PathVariable("Id") Long Id) {

    	approvermasterService.destroyApproverMaster(Id);
    }

   
    

    
}
