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
import com.example.master.dto.HolidayMasterDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.HolidayMaster;
import com.example.master.services.HolidayMasterService;
import com.example.master.services.serviceImpl.HolidayMasterServiceImpl;

@RestController
@RequestMapping("/holidaymaster/")
public class HolidayMasterController implements HolidayMasterService {

    @Autowired
    HolidayMasterServiceImpl holidaymasterService;


    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addHolidayMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<HolidayMasterDTO> persistHolidayMaster(@RequestBody HolidayMasterDTO holidaymasterDTO) {

    	holidaymasterService.persistHolidayMaster(holidaymasterDTO);
    	
	return new ResponseEntity<HolidayMasterDTO>(holidaymasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateHolidayMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<HolidayMasterDTO> updateHolidayMaster(@RequestBody HolidayMasterDTO holidaymasterDTO) {

    	holidaymasterService.updateHolidayMaster(holidaymasterDTO);
    	
	return new ResponseEntity<HolidayMasterDTO>(holidaymasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllHolidayMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<HolidayMasterDTO> populateHolidayMasterList() {
    	return holidaymasterService.populateHolidayMasterList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getHolidayMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public HolidayMasterDTO populateOneHolidayMasterDetails(@PathVariable("Id") Long Id) {
    	return holidaymasterService.populateOneHolidayMasterDetails(Id);
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteHolidayMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyHolidayMaster(@PathVariable("Id") Long Id) {

    	holidaymasterService.destroyHolidayMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
