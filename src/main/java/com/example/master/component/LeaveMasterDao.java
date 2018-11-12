package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.LeaveMaster;
import com.example.master.repository.LeaveMasterRepository;

@Component
public class LeaveMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    LeaveMasterRepository leavemasterRepository;

    @Transactional(readOnly = true)
    public List<LeaveMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return leavemasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public LeaveMaster findLeaveMasterById(Long id) {
    	return leavemasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addLeaveMaster(LeaveMaster leavemaster) {
    	leavemasterRepository.save(leavemaster);
    	LOGGER.info("Country added successfully " + leavemaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLeaveMaster(Long Id) {
    	leavemasterRepository.delete(Id);
    	LOGGER.info("Activity with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateLeaveMaster(LeaveMaster leavemaster) {
    	leavemasterRepository.save(leavemaster);
    	LOGGER.info("Activity added successfully " + leavemaster.toString());
    }
}
