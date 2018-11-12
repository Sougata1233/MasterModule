package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.Codemaster;
import com.example.master.repository.CodemasterRepository;


@Component
public class CodemasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodemasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    CodemasterRepository codemasterRepository;

    @Transactional(readOnly = true)
    public List<Codemaster> findAll() throws Exception {
		return codemasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Codemaster findByCode(String code) {
    	return codemasterRepository.findOne(code);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCodemaster(Codemaster codemaster) {
    	codemasterRepository.save(codemaster);
    	LOGGER.info("Codemaster added successfully " + codemaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCodemaster(String code) {
    	codemasterRepository.delete(code);
    	LOGGER.info("Codemaster with id " + code + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCodemaster(Codemaster codemaster) {
    	codemasterRepository.save(codemaster);
    	LOGGER.info("Activity added successfully " + codemaster.toString());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Codemaster> getCodemasterByCodeType(String codeType) {
    	return codemasterRepository.findByCodeType(codeType);
    	
    }
}
