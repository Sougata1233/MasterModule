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
import com.example.master.dto.MenuMasterDTO;
import com.example.master.dto.SubmenuMasterDTO;
import com.example.master.entity.SubmenuMaster;
import com.example.master.services.SubmenuMasterService;
import com.example.master.services.serviceImpl.SubmenuMasterServiceImpl;


@RestController
@RequestMapping("/submenuMaster/")
public class SubmenuMasterController implements SubmenuMasterService {

    @Autowired
    SubmenuMasterServiceImpl submenumasterService;


    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addSubmenuMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubmenuMasterDTO> persistSubmenuMaster(@RequestBody SubmenuMasterDTO submenumasterDTO) {

    	submenumasterService.persistSubmenuMaster(submenumasterDTO);
    	
	return new ResponseEntity<SubmenuMasterDTO>(submenumasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateSubmenuMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubmenuMasterDTO> updateSubmenuMaster(@RequestBody SubmenuMasterDTO submenumasterDTO) {

    	submenumasterService.updateSubmenuMaster(submenumasterDTO);
    	
	return new ResponseEntity<SubmenuMasterDTO>(submenumasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllSubmenuMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmenuMasterDTO> populateSubmenuMasterList() {
	
    	return submenumasterService.populateSubmenuMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getSubmenuMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public SubmenuMasterDTO populateOneSubmenuMasterDetails(@PathVariable("Id") Long Id) {
    
    	return submenumasterService.populateOneSubmenuMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteSubmenuMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroySubmenuMaster(@PathVariable("Id") Long Id) {

    	submenumasterService.destroySubmenuMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
