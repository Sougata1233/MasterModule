package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.SelectionQualityMaster;
import com.example.master.repository.SelectionQualityMasterRepository;


@Component
public class SelectionQualityMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SelectionQualityMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    SelectionQualityMasterRepository selectionqualitymasterRepository;

    @Transactional(readOnly = true)
    public List<SelectionQualityMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return selectionqualitymasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SelectionQualityMaster findSelectionQualityMasterById(Long id) {
    	return selectionqualitymasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addSelectionQualityMaster(SelectionQualityMaster selectionqualitymaster) {
    	selectionqualitymasterRepository.save(selectionqualitymaster);
    	LOGGER.info("Activity added successfully " + selectionqualitymaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSelectionQualityMaster(Long Id) {
    	selectionqualitymasterRepository.delete(Id);
    	LOGGER.info("SelectionQualityMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSelectionQualityMaster(SelectionQualityMaster selectionqualitymaster) {
    	selectionqualitymasterRepository.save(selectionqualitymaster);
    	LOGGER.info("SelectionQualityMaster added successfully " + selectionqualitymaster.toString());
    }
}
