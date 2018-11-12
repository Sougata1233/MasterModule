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

import com.example.master.entity.Usergroup;
import com.example.master.repository.UsergroupRepository;


@Component
public class UsergroupDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsergroupDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UsergroupRepository usergroupRepository;

    @Transactional(readOnly = true)
    public List<Usergroup> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return usergroupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usergroup findUsergroupById(Long id) {
    	return usergroupRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUsergroup(Usergroup usergroup) {
    	usergroupRepository.save(usergroup);
    	LOGGER.info("Usergroup added successfully " + usergroup.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUsergroup(Long userId) {
    	usergroupRepository.delete(userId);
    	LOGGER.info("Usergroup with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUsergroup(Usergroup usergroup) {
    	usergroupRepository.save(usergroup);
    	LOGGER.info("Activity added successfully " + usergroup.toString());
    }
}
