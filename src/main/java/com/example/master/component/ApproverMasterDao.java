package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.ApproverMaster;
import com.example.master.repository.ApproverMasterRepository;


@Component
public class ApproverMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApproverMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ApproverMasterRepository approvermasterRepository;

    @Transactional(readOnly = true)
    public List<ApproverMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return approvermasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ApproverMaster findApproverMasterById(Long id) {
		return approvermasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addApproverMaster(ApproverMaster approvermaster) {
    	approvermasterRepository.save(approvermaster);
    	LOGGER.info("ApproverMaster added successfully " + approvermaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteApproverMaster(Long Id) {
    	approvermasterRepository.delete(Id);
    	LOGGER.info("ApproverMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateApproverMaster(ApproverMaster approvermaster) {
    	approvermasterRepository.save(approvermaster);
    	LOGGER.info("ApproverMaster added successfully " + approvermaster.toString());
    }
}
