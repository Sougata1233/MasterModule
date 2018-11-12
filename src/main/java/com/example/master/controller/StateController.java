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

import com.example.master.dto.CountryDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StateDTO;
import com.example.master.entity.State;
import com.example.master.services.StateService;
import com.example.master.services.serviceImpl.StateServiceImpl;


@RestController
@RequestMapping("/state/")
public class StateController implements StateService {

    @Autowired
    StateServiceImpl stateService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addState", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StateDTO> persistState(@RequestBody StateDTO stateDTO) {
    	
    	stateService.persistState(stateDTO);
    	
	return new ResponseEntity<StateDTO>(stateDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateState", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StateDTO> updateState(@RequestBody StateDTO stateDTO) {

    	stateService.updateState(stateDTO);
    	
	return new ResponseEntity<StateDTO>(stateDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllState", method = RequestMethod.GET)
    @ResponseBody
    public List<StateDTO> populateStateList() {
	
    	return stateService.populateStateList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByStateId/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public StateDTO populateOneStateDetails(@PathVariable("Id") long Id) {
    
    	return stateService.populateOneStateDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteState/{stateId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyState(@PathVariable("stateId") long stateId) {
    	return stateService.destroyState(stateId);
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getStateByCountry/{countryId}", method = RequestMethod.GET)
    @ResponseBody
	public List<StateDTO> getAllStateByCountry(@PathVariable("countryId") long countryId) {
		return stateService.getAllStateByCountry(countryId);
	}

   
    

    
}
