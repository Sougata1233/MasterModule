package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.Country;
import com.example.master.repository.CountryRepository;


@Component
public class CountryDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryById(long id) {
    	return countryRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCountry(Country country) {
    	countryRepository.save(country);
    	LOGGER.info("Country added successfully " + country.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCountry(long countryId) {
    	countryRepository.delete(countryId);
    	LOGGER.info("Activity with id " + countryId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCountry(Country country) {
    	countryRepository.save(country);
    	LOGGER.info("Activity added successfully " + country.toString());
    }
    
    @Transactional
    public List<Country> getCountryByState(long stateId){
    	return countryRepository.findByStatesId(stateId);
    }
}
