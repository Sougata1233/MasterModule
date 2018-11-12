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

import com.example.master.entity.ItemGroupMaster;
import com.example.master.repository.ItemGroupMasterRepository;


@Component
public class ItemGroupMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemGroupMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ItemGroupMasterRepository itemgroupmasterRepository;

    @Transactional(readOnly = true)
    public List<ItemGroupMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return itemgroupmasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ItemGroupMaster findItemGroupMasterById(String id) {
    	return itemgroupmasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addItemGroupMaster(ItemGroupMaster itemgroupmaster) {
    	itemgroupmasterRepository.save(itemgroupmaster);
    	LOGGER.info("Country added successfully " + itemgroupmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteItemGroupMaster(String Id) {
    	itemgroupmasterRepository.delete(Id);
    	LOGGER.info("Activity with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateItemGroupMaster(ItemGroupMaster itemgroupmaster) {
    	itemgroupmasterRepository.save(itemgroupmaster);
    	LOGGER.info("Activity added successfully " + itemgroupmaster.toString());
    }
    
    @Transactional
    public List<ItemGroupMaster> findItemGroupFiltered(){
    	return itemgroupmasterRepository.findByGroupIdFilter();
    }
}
