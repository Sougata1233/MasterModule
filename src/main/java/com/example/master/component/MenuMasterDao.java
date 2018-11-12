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

import com.example.master.entity.MenuMaster;
import com.example.master.repository.MenuMasterRepository;


@Component
public class MenuMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    MenuMasterRepository menuRepository;

    @Transactional(readOnly = true)
    public List<MenuMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return menuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MenuMaster findMenuMasterById(Long id) {
    	return menuRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMenuMaster(MenuMaster menu) {
    	menuRepository.save(menu);
    	LOGGER.info("MenuMaster added successfully " + menu.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMenuMaster(Long Id) {
    	menuRepository.delete(Id);
    	LOGGER.info("MenuMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMenuMaster(MenuMaster menu) {
    	menuRepository.save(menu);
    	LOGGER.info("MenuMaster added successfully " + menu.toString());
    }
}
