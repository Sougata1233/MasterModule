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
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.LocationMaster;
import com.example.master.services.LocationMasterService;
import com.example.master.services.serviceImpl.LocationMasterServiceImpl;


@RestController
@RequestMapping("/locationMaster/")
public class LocationMasterController implements LocationMasterService {

    @Autowired
    LocationMasterServiceImpl locationmasterService;
    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addLocationMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<LocationMasterDTO> persistLocationMaster(@RequestBody LocationMasterDTO locationmasterDTO) {

    	locationmasterService.persistLocationMaster(locationmasterDTO);
    	
	return new ResponseEntity<LocationMasterDTO>(locationmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateLocationMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<LocationMasterDTO> updateLeaveMaster(@RequestBody LocationMasterDTO locationmasterDTO) {

    	locationmasterService.updateLeaveMaster(locationmasterDTO);
    	
	return new ResponseEntity<LocationMasterDTO>(locationmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllLocationMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<LocationMasterDTO> populateLocationMasterList() {
	
    	return locationmasterService.populateLocationMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByLocationMasterId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public LocationMasterDTO populateOneLocationMasterDetails(@PathVariable("userId") Long userId) {
    
    	return locationmasterService.populateOneLocationMasterDetails(userId);
    
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteLocationMaster/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyLocationMaster(@PathVariable("userId") Long userId) {

    	locationmasterService.destroyLocationMaster(userId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
