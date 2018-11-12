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

import com.example.master.entity.Mukam;
import com.example.master.repository.MukamRepository;


@Component
public class MukamDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MukamDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    MukamRepository mukamRepository;

    @Transactional(readOnly = true)
    public List<Mukam> findAll() throws Exception {
    	return mukamRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Mukam findMukamById(Long id) {
    	return mukamRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public List<Mukam> findAllByMukamById(Long id) {
    	return mukamRepository.findById(id);
    }
    
    @Transactional
    public Mukam getMukamById(Long id) {
    	return mukamRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public Mukam findAllByMukamByIdEntity(long id) {
    	return mukamRepository.findByIdEntity(id);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void addMukam(Mukam mukam) {
    	mukamRepository.save(mukam);
    	LOGGER.info("Mukam added successfully " + mukam.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMukam(Long userId) {
    	mukamRepository.delete(userId);
    	LOGGER.info("Mukam with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMukam(Mukam mukam) {
    	mukamRepository.save(mukam);
    	LOGGER.info("Mukam added successfully " + mukam.toString());
    }
    
    @Transactional
    public Mukam findByMukamName(String mukamname) {
    	return mukamRepository.findByMukamName(mukamname);
    }

    @Transactional
	public void save(Mukam mukamEntity) {
		mukamRepository.save(mukamEntity);
	}
}
