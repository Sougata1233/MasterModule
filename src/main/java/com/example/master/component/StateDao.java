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

import com.example.master.dto.StateDTO;
import com.example.master.entity.State;
import com.example.master.repository.StateRepository;


@Component
public class StateDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(StateDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    StateRepository stateRepository;

    @Transactional(readOnly = true)
    public List<State> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return stateRepository.findAll();
    }

    @Transactional(readOnly = true)
    public State findStateById(long id) {
    	return stateRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addState(State state) {
    	stateRepository.save(state);
    	LOGGER.info("State added successfully " + state.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteState(long stateId) {
    	stateRepository.delete(stateId);
    	LOGGER.info("State with id " + stateId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateState(State state) {
    	stateRepository.save(state);
	LOGGER.info("State added successfully " + state.toString());
    }
    
    @Transactional
    public List<State> getStateByCountry(long countryId){
    	return stateRepository.findByCountryId(countryId);
    }
}
