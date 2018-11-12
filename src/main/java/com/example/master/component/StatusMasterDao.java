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

import com.example.master.entity.StatusMaster;
import com.example.master.repository.StatusMasterRepository;

@Component
public class StatusMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    StatusMasterRepository statusmasterRepository;

    @Transactional(readOnly = true)
    public List<StatusMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return statusmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public StatusMaster findStatusMasterById(Long id) {
    	return statusmasterRepository.findOne(id);
    }

    

    @Transactional(propagation = Propagation.REQUIRED)
    public void addStatusMaster(StatusMaster statusmaster) {
    	statusmasterRepository.save(statusmaster);
    	LOGGER.info("State added successfully " + statusmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStatusMaster(Long Id) {
    	statusmasterRepository.delete(Id);
    	LOGGER.info("State with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStatusMaster(StatusMaster statusmaster) {
    	statusmasterRepository.save(statusmaster);
	LOGGER.info("State added successfully " + statusmaster.toString());
    }
}
