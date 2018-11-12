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

import com.example.master.entity.Organization;
import com.example.master.repository.OrganizationRepository;

@Component
public class OrganizationDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    OrganizationRepository organizationRepository;

    @Transactional(readOnly = true)
    public List<Organization> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return organizationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Organization findOrganizationById(Long id) {
    	return organizationRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addOrganization(Organization organization) {
    	organizationRepository.save(organization);
    	LOGGER.info("Organization added successfully " + organization.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOrganization(Long Id) {
    	organizationRepository.delete(Id);
    	LOGGER.info("Organization with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrganization(Organization organization) {
    	organizationRepository.save(organization);
	LOGGER.info("Organization added successfully " + organization.toString());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Organization> getAllHeadOrganizations() {
    
    	return organizationRepository.findByHierarchyId();
	
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Organization getAllOrganizationsByName(String orgName) {
    	return organizationRepository.findByOrgName(orgName);
	}
}
