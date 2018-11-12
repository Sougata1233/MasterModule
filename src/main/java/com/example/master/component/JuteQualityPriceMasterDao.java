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

import com.example.master.entity.JuteQualityPriceMaster;
import com.example.master.repository.JuteQualityPriceMasterRepository;


@Component
public class JuteQualityPriceMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(JuteQualityPriceMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    JuteQualityPriceMasterRepository juteqltpricemasterRepository;

    @Transactional(readOnly = true)
    public List<JuteQualityPriceMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return juteqltpricemasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public JuteQualityPriceMaster findJuteQualityPriceMasterById(Long id) {
    	return juteqltpricemasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addJuteQualityPriceMaster(JuteQualityPriceMaster juteqltpricemaster) {
    	juteqltpricemasterRepository.save(juteqltpricemaster);
    	LOGGER.info("Country added successfully " + juteqltpricemaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteJuteQualityPriceMaster(Long Id) {
    	juteqltpricemasterRepository.delete(Id);
    	LOGGER.info("Activity with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateJuteQualityPriceMaster(JuteQualityPriceMaster juteqltpricemaster) {
    	juteqltpricemasterRepository.save(juteqltpricemaster);
    	LOGGER.info("Activity added successfully " + juteqltpricemaster.toString());
    }
}
