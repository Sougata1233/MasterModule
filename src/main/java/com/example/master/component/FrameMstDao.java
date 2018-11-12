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

import com.example.master.entity.FrameMst;
import com.example.master.repository.FrameMstRepository;

@Component
public class FrameMstDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(FrameMstDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    FrameMstRepository framemstRepository;

    @Transactional(readOnly = true)
    public List<FrameMst> findAll() throws Exception {
		return framemstRepository.findAll();
    }

    @Transactional(readOnly = true)
    public FrameMst findFrameMstById(Long id) {
    	return framemstRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addFrameMst(FrameMst framemst) {
    	framemstRepository.save(framemst);
    	LOGGER.info("FrameMst added successfully " + framemst.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteFrameMst(Long Id) {
    	framemstRepository.delete(Id);
    	LOGGER.info("FrameMst with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateFrameMst(FrameMst framemst) {
    	framemstRepository.save(framemst);
    	LOGGER.info("FrameMst added successfully " + framemst.toString());
    }
}
