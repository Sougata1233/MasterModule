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
import com.example.master.dto.SelectionQualityMasterDTO;
import com.example.master.entity.SelectionQualityMaster;
import com.example.master.services.SelectionQualityMasterService;
import com.example.master.services.serviceImpl.SelectionQualityMasterServiceImpl;


@RestController
@RequestMapping("/SelectionQualityMaster/")
public class SelectionQualityMasterController implements SelectionQualityMasterService {

    @Autowired
    SelectionQualityMasterServiceImpl selectionqualitymasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addSelectionQualityMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SelectionQualityMasterDTO> persistSelectionQualityMaster
    												(@RequestBody SelectionQualityMasterDTO selectionqualitymasterDTO) {

    	selectionqualitymasterService.persistSelectionQualityMaster(selectionqualitymasterDTO);
    	
	return new ResponseEntity<SelectionQualityMasterDTO>(selectionqualitymasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateSelectionQualityMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SelectionQualityMasterDTO> updateSelectionQualityMaster
    												(@RequestBody SelectionQualityMasterDTO selectionqualitymasterDTO) {

    	selectionqualitymasterService.updateSelectionQualityMaster(selectionqualitymasterDTO);
    	
	return new ResponseEntity<SelectionQualityMasterDTO>(selectionqualitymasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllSelectionQualityMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectionQualityMasterDTO> populateSelectionQualityMasterList() {
	
    	return selectionqualitymasterService.populateSelectionQualityMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getSelectionQualityMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public SelectionQualityMasterDTO populateOneSelectionQualityMasterDetails(@PathVariable("Id") Long Id) {
    
    	return selectionqualitymasterService.populateOneSelectionQualityMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteSelectionQualityMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyScmIndentTypeMaster(@PathVariable("Id") Long Id) {

    	selectionqualitymasterService.destroyScmIndentTypeMaster(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
