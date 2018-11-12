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

import com.example.master.entity.SubmenuMaster;
import com.example.master.repository.SubmenuMasterRepository;


@Component
public class SubmenuMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubmenuMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    SubmenuMasterRepository submenumasterRepository;

    @Transactional(readOnly = true)
    public List<SubmenuMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return submenumasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SubmenuMaster findSubmenuMasterById(Long id) {
    	return submenumasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addSubmenuMaster(SubmenuMaster submenumaster) {
    	submenumasterRepository.save(submenumaster);
    	LOGGER.info("State added successfully " + submenumaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSubmenuMaster(Long Id) {
    	submenumasterRepository.delete(Id);
    	LOGGER.info("State with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSubmenuMaster(SubmenuMaster submenumaster) {
    	submenumasterRepository.save(submenumaster);
    	LOGGER.info("State added successfully " + submenumaster.toString());
    }
}
