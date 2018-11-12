package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.CountryDTO;
import com.example.master.dto.StateDTO;
import com.example.master.dto.CityDTO;
import com.example.master.dto.DeleteDTO;


public interface CountryService {

    public ResponseEntity<CountryDTO> persistCountry(CountryDTO country);
    public CountryDTO populateOneCountryDetails(long countryId);
    public List<CountryDTO> populateCountryList();
    public DeleteDTO destroyCountry(long userId);
    ResponseEntity<CountryDTO> updateCountry(CountryDTO activityDTO);
    public List<CountryDTO> getCountryByState(long stateId);
    
    
    

}
