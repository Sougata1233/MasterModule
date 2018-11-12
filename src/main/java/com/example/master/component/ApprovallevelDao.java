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
import com.example.master.repository.ApprovallevelRepository;


@Component
public class ApprovallevelDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApprovallevelDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ApprovallevelRepository approvallevelRepository;

    @Transactional(readOnly = true)
    public List<Country> findAll() throws Exception {
		return approvallevelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryById(long id) {
		return approvallevelRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCountry(Country country) {
    	approvallevelRepository.save(country);
	LOGGER.info("Country added successfully " + country.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCountry(long userId) {
    	approvallevelRepository.delete(userId);
	LOGGER.info("Activity with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCountry(Country country) {
    	approvallevelRepository.save(country);
	LOGGER.info("Activity added successfully " + country.toString());
    }
}
