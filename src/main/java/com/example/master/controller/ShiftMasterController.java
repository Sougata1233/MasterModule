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
import com.example.master.dto.ShiftMasterDTO;
import com.example.master.entity.ShiftMaster;
import com.example.master.services.ShiftMasterService;
import com.example.master.services.serviceImpl.ShiftMasterServiceImpl;


@RestController
@RequestMapping("/shiftMaster/")
public class ShiftMasterController implements ShiftMasterService {

    @Autowired
    ShiftMasterServiceImpl shiftmasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addShiftMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ShiftMasterDTO> persistShiftMaster(@RequestBody ShiftMasterDTO shiftmasterDTO) {
    	
    	shiftmasterService.persistShiftMaster(shiftmasterDTO);
    	
	return new ResponseEntity<ShiftMasterDTO>(shiftmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateShiftMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ShiftMasterDTO> updateShiftMaster(@RequestBody ShiftMasterDTO shiftmasterDTO) {

    	shiftmasterService.updateShiftMaster(shiftmasterDTO);
    	
	return new ResponseEntity<ShiftMasterDTO>(shiftmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllShiftMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<ShiftMasterDTO> populateShiftMasterList() {
	
    	return shiftmasterService.populateShiftMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getShiftMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public ShiftMasterDTO populateOneShiftMasterDetails(@PathVariable("Id") Long Id) {
    
    	return shiftmasterService.populateOneShiftMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteShiftMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyShiftMaster(@PathVariable("Id") Long Id) {

    	shiftmasterService.destroyShiftMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
