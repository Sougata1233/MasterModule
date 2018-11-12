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

import com.example.master.entity.Usergroupmenu;
import com.example.master.repository.UsergroupmenuRepository;


@Component
public class UsergroupmenuDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsergroupmenuDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UsergroupmenuRepository usergroupmenuRepository;

    @Transactional(readOnly = true)
    public List<Usergroupmenu> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return usergroupmenuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usergroupmenu findUsergroupmenuById(Long id) {
    	return usergroupmenuRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUsergroupmenu(Usergroupmenu usergroupmenu) {
    	usergroupmenuRepository.save(usergroupmenu);
    	LOGGER.info("Activity added successfully " + usergroupmenu.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUsergroupmenu(Long userId) {
    	usergroupmenuRepository.delete(userId);
    	LOGGER.info("Usergroupmenu with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUsergroupmenu(Usergroupmenu usergroupmenu) {
    	usergroupmenuRepository.save(usergroupmenu);
    	LOGGER.info("Activity added successfully " + usergroupmenu.toString());
    }
    
    
}
