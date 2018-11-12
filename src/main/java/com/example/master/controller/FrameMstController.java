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
import com.example.master.dto.FrameMstDTO;
import com.example.master.entity.FrameMst;
import com.example.master.services.FrameMstService;
import com.example.master.services.serviceImpl.FrameMstServiceImpl;


@RestController
@RequestMapping("/framemaster/")
public class FrameMstController implements FrameMstService {

    @Autowired
    FrameMstServiceImpl framemstService;


    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addFrameMst", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<FrameMstDTO> persistUser(@RequestBody FrameMstDTO framemstDTO) {

    	framemstService.persistUser(framemstDTO);
    	
	return new ResponseEntity<FrameMstDTO>(framemstDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateFrameMst", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<FrameMstDTO> updateFrameMst(@RequestBody FrameMstDTO framemstDTO) {

    	framemstService.updateFrameMst(framemstDTO);
    	
	return new ResponseEntity<FrameMstDTO>(framemstDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllFrameMst", method = RequestMethod.GET)
    @ResponseBody
    public List<FrameMstDTO> populateFrameMstList() {
    	return framemstService.populateFrameMstList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getFrameMstById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public FrameMstDTO populateOneFrameMstDetails(@PathVariable("Id") Long Id) {
    	return framemstService.populateOneFrameMstDetails(Id);
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteFrameMst/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyFrameMst(@PathVariable("Id") Long Id) {

    	framemstService.destroyFrameMst(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
