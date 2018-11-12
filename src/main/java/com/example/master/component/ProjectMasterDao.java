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

import com.example.master.entity.ProjectMaster;
import com.example.master.repository.ProjectMasterRepository;


@Component
public class ProjectMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ProjectMasterRepository projectmasterRepository;

    @Transactional(readOnly = true)
    public List<ProjectMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return projectmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ProjectMaster findProjectMasterById(Long id) {
    	return projectmasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addProjectMaster(ProjectMaster projectmaster) {
    	projectmasterRepository.save(projectmaster);
    	LOGGER.info("ApproverMaster added successfully " + projectmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProjectMaster(Long Id) {
    	projectmasterRepository.delete(Id);
	LOGGER.info("ProjectMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateProjectMaster(ProjectMaster projectmaster) {
    	projectmasterRepository.save(projectmaster);
	LOGGER.info("ApproverMaster added successfully " + projectmaster.toString());
    }
}
