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

import com.example.master.dto.ItemMasterDTO;
import com.example.master.entity.ItemMaster;
import com.example.master.repository.ItemMasterRepository;


@Component
public class ItemMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ItemMasterRepository itemmasterRepository;

    @Transactional(readOnly = true)
    public List<ItemMaster> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return itemmasterRepository.findAll();
    }

    @Transactional
    public ItemMaster getItemMasterByItemDesc(String itemDesc) {
    	return itemmasterRepository.findByItemDsc(itemDesc);
    }

    @Transactional(readOnly = true)
    public ItemMaster findItemMasterById(String id) {
    	return itemmasterRepository.findOne(id);
    }
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void addItemMaster(ItemMaster itemmaster) {
    	itemmasterRepository.save(itemmaster);
    	LOGGER.info("ItemMaster added successfully " + itemmaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteItemMaster(String Id) {
    	itemmasterRepository.delete(Id);
    	LOGGER.info("ItemMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateItemMaster(ItemMaster itemmaster) {
    	itemmasterRepository.save(itemmaster);
    	LOGGER.info("ItemMaster added successfully " + itemmaster.toString());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ItemMaster> getItemMasterByGroupCode(String groupcode) {
    	return itemmasterRepository.findByGrpCode(groupcode);
    }
    
    public long seqNextVal() {
    	return itemmasterRepository.getNextSeriesId();
    }
    
    public long seqPresentVal() {
    	return itemmasterRepository.getPresentSeq();
    }
    
    public ItemMaster save(ItemMaster itemmasterEntity) {
    	return itemmasterRepository.save(itemmasterEntity);
    }
    
}
