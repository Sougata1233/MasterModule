package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.ShiftMaster;
import com.example.master.repository.ShiftMasterRepository;

@Component
public class ShiftMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiftMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ShiftMasterRepository shiftmasterRepository;

    @Transactional(readOnly = true)
    public List<ShiftMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return shiftmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ShiftMaster findShiftMasterById(Long id) {
    	return shiftmasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addShiftMaster(ShiftMaster shiftmaster) {
    	shiftmasterRepository.save(shiftmaster);
    	LOGGER.info("Activity added successfully " + shiftmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteShiftMaster(Long Id) {
    	shiftmasterRepository.delete(Id);
    	LOGGER.info("ShiftMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateShiftMaster(ShiftMaster shiftmaster) {
    	shiftmasterRepository.save(shiftmaster);
    	LOGGER.info("ShiftMaster added successfully " + shiftmaster.toString());
    }
}
