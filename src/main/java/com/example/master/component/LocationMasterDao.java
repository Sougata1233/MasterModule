package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.LocationMaster;
import com.example.master.repository.LocationMasterRepository;

@Component
public class LocationMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    LocationMasterRepository locationmasterRepository;

    @Transactional(readOnly = true)
    public List<LocationMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return locationmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public LocationMaster findLocationMasterById(Long id) {
    	return locationmasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addLocationMaster(LocationMaster locationmaster) {
    	locationmasterRepository.save(locationmaster);
    	LOGGER.info("Country added successfully " + locationmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLocationMaster(Long Id) {
    	locationmasterRepository.delete(Id);
    	LOGGER.info("Activity with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateLeaveMaster(LocationMaster locationmaster) {
    	locationmasterRepository.save(locationmaster);
    	LOGGER.info("Activity added successfully " + locationmaster.toString());
    }
    
    @Transactional
	public LocationMaster getLocationById(long id) {
		return locationmasterRepository.findOne(id);
	}
    
}
