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

import com.example.master.entity.ScmIndentTypeMaster;
import com.example.master.repository.ScmIndentTypeMasterRepository;

@Component
public class ScmIndentTypeMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScmIndentTypeMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ScmIndentTypeMasterRepository scmInttypmasterRepository;

    @Transactional(readOnly = true)
    public List<ScmIndentTypeMaster> findAll() throws Exception {
    	LOGGER.info("DATASOURCE = " + dataSource);
		return scmInttypmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ScmIndentTypeMaster findScmIndentTypeMasterById(Long id) {
    	return scmInttypmasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addScmIndentTypeMaster(ScmIndentTypeMaster scmInttypmaster) {
    	scmInttypmasterRepository.save(scmInttypmaster);
    	LOGGER.info("ScmIndentTypeMaster added successfully " + scmInttypmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteScmIndentTypeMaster(Long Id) {
    	scmInttypmasterRepository.delete(Id);
    	LOGGER.info("ScmIndentTypeMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateScmIndentTypeMaster(ScmIndentTypeMaster scmInttypmaster) {
    	scmInttypmasterRepository.save(scmInttypmaster);
    	LOGGER.info("ScmIndentTypeMaster added successfully " + scmInttypmaster.toString());
    }
}
