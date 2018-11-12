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

import com.example.master.entity.Weekend;
import com.example.master.repository.WeekendRepository;


@Component
public class WeekendDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeekendDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    WeekendRepository weekendRepository;

    @Transactional(readOnly = true)
    public List<Weekend> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return weekendRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Weekend findWeekendById(Long id) {
    	return weekendRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addWeekend(Weekend weekend) {
    	weekendRepository.save(weekend);
    	LOGGER.info("Activity added successfully " + weekend.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteWeekend(Long weekendId) {
    	weekendRepository.delete(weekendId);
    	LOGGER.info("Weekend with id " + weekendId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateWeekend(Weekend weekend) {
    	weekendRepository.save(weekend);
    	LOGGER.info("Activity added successfully " + weekend.toString());
    }
}
