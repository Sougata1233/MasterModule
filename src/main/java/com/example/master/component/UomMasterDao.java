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

import com.example.master.entity.UomMaster;
import com.example.master.repository.UomMasterRepository;

@Component
public class UomMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UomMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UomMasterRepository uommasterRepository;

    @Transactional(readOnly = true)
    public List<UomMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return uommasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public UomMaster findUomMasterById(String id) {
    	return uommasterRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<UomMaster> findUomMasterByIdList(String id) {
    	return uommasterRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUomMaster(UomMaster uommaster) {
    	uommasterRepository.save(uommaster);
    	LOGGER.info("UomMaster added successfully " + uommaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUomMaster(String Id) {
    	uommasterRepository.delete(Id);
    	LOGGER.info("UomMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUomMaster(UomMaster uommaster) {
    	uommasterRepository.save(uommaster);
    	LOGGER.info("ApproverMaster added successfully " + uommaster.toString());
    }
    
    @Transactional
    public List<UomMaster> getUomByUomDsc(String uomDsc){
    	return uommasterRepository.findByUomDsc(uomDsc);
    }
}
