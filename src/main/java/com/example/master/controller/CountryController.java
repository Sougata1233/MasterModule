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
import com.example.master.entity.Country;
import com.example.master.entity.State;
import com.example.master.services.CountryService;
import com.example.master.services.serviceImpl.CountryServiceImpl;


@RestController
@RequestMapping("/country/")
public class CountryController implements CountryService {

    @Autowired
    CountryServiceImpl countryService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addCountry", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CountryDTO> persistCountry(@RequestBody CountryDTO countryDTO) {

    	countryService.persistCountry(countryDTO);
    	
	return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateCountry", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO countryDTO) {

    	countryService.updateCountry(countryDTO);
    	
	return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllCountry", method = RequestMethod.GET)
    @ResponseBody
    public List<CountryDTO> populateCountryList() {
    	return countryService.populateCountryList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByCountryId/{countryId}", method = RequestMethod.GET)
    @ResponseBody
    public CountryDTO populateOneCountryDetails(@PathVariable("countryId") long countryId) {
    	return countryService.populateOneCountryDetails(countryId);
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteCountry/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyCountry(@PathVariable("Id") long Id) {

    	return countryService.destroyCountry(Id);
    	
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getCountryByState/{stateId}", method = RequestMethod.GET)
    @ResponseBody
	public List<CountryDTO> getCountryByState(@PathVariable("stateId") long stateId) {
		return countryService.getCountryByState(stateId);
	}

   
    

    
}
