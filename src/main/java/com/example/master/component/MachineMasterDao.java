package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.MachineMaster;
import com.example.master.repository.MachineMasterRepository;


@Component
public class MachineMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    MachineMasterRepository machinemasterRepository;

    @Transactional(readOnly = true)
    public List<MachineMaster> findAll() throws Exception {
    	LOGGER.info("DATASOURCE = " + dataSource);
		return machinemasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MachineMaster findMachineMasterById(String id) {
    	return machinemasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMachineMaster(MachineMaster machinemaster) {
    	machinemasterRepository.save(machinemaster);
		LOGGER.info("State added successfully " + machinemaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMachineMaster(String Id) {
    	machinemasterRepository.delete(Id);
    	LOGGER.info("MachineMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMachineMaster(MachineMaster machinemaster) {
    	machinemasterRepository.save(machinemaster);
    	LOGGER.info("MachineMaster added successfully " + machinemaster.toString());
    }
}
