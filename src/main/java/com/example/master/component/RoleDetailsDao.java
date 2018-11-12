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

import com.example.master.entity.RoleDetails;
import com.example.master.repository.RoleDetailsRepository;

@Component
public class RoleDetailsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDetailsDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    RoleDetailsRepository roledetailsRepository;

    @Transactional(readOnly = true)
    public List<RoleDetails> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return roledetailsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RoleDetails findRoleDetailsById(Long id) {
    	return roledetailsRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRoleDetails(RoleDetails roledetails) {
    	roledetailsRepository.save(roledetails);
    	LOGGER.info("ApproverMaster added successfully " + roledetails.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRoleDetails(Long Id) {
    	roledetailsRepository.delete(Id);
    	LOGGER.info("RoleDetails with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateRoleDetails(RoleDetails roledetails) {
    	roledetailsRepository.save(roledetails);
    	LOGGER.info("ApproverMaster added successfully " + roledetails.toString());
    }
}
