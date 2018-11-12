package com.example.master.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.City;
import com.example.master.repository.CityRepository;


@Component
public class CityDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<City> findAll() throws Exception {
		return cityRepository.findAll();
    }
    

    @Transactional(readOnly = true)
    public City findCityById(long id) {
    	return cityRepository.findOne(id);
    }

    

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCity(City city) {
    	cityRepository.save(city);
    	LOGGER.info("City added successfully " + city.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCity(long Id) {
    	cityRepository.delete(Id);
    	LOGGER.info("City with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCity(City city) {
    	cityRepository.save(city);
    	LOGGER.info("Activity added successfully " + city.toString());
    }
    
    @Transactional
    public List<City> getCityByState(long stateId){
    	return cityRepository.findByStateId(stateId);
    }
}
