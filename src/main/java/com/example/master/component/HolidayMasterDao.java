package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.HolidayMaster;
import com.example.master.repository.HolidayMasterRepository;


@Component
public class HolidayMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(HolidayMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    HolidayMasterRepository holidaymasterRepository;

    @Transactional(readOnly = true)
    public List<HolidayMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return holidaymasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HolidayMaster findHolidayMasterById(Long id) {
		return holidaymasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addHolidayMaster(HolidayMaster holidaymaster) {
    	holidaymasterRepository.save(holidaymaster);
    	LOGGER.info("HolidayMaster added successfully " + holidaymaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteHolidayMaster(Long Id) {
    	holidaymasterRepository.delete(Id);
    	LOGGER.info("HolidayMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateHolidayMaster(HolidayMaster holidaymaster) {
    	holidaymasterRepository.save(holidaymaster);
    	LOGGER.info("HolidayMaster added successfully " + holidaymaster.toString());
    }
}
