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

import com.example.master.dto.CityDTO;
import com.example.master.dto.CountryDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StateDTO;
import com.example.master.entity.City;
import com.example.master.services.CityService;
import com.example.master.services.serviceImpl.CityServiceImpl;

@RestController
@RequestMapping("/city/")
public class CityController implements CityService {

    @Autowired
    CityServiceImpl cityService;

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addCity", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CityDTO> persistCity(@RequestBody CityDTO cityDTO) {
    	cityService.persistCity(cityDTO);
	return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateCity", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO cityDTO) {
    	cityService.updateCity(cityDTO);
	return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllCity", method = RequestMethod.GET)
    @ResponseBody
    public List<CityDTO> populateCityList() {
    	return cityService.populateCityList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getCityById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public CityDTO populateOneCityDetails(@PathVariable("Id") int Id) {
    	return cityService.populateOneCityDetails(Id);
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteCity/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyCity(@PathVariable("Id") int Id) {
    	return cityService.destroyCity(Id);
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getCityByState/{stateId}", method = RequestMethod.GET)
    @ResponseBody
	public List<CityDTO> getCityByState(@PathVariable("stateId") long stateId) {
		return cityService.getCityByState(stateId);
	}

   
    

    
}
