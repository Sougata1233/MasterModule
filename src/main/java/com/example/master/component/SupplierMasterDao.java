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

import com.example.master.entity.SupplierMaster;
import com.example.master.repository.SupplierMasterRepository;


@Component
public class SupplierMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    SupplierMasterRepository suppliermasterRepository;
    
    public long seqNextVal() {
    	return suppliermasterRepository.getNextSeriesId();
    }
    
    @Transactional(readOnly = true)
    public List<SupplierMaster> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
		return suppliermasterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SupplierMaster findSupplierMasterById(String id) {
    	return suppliermasterRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public SupplierMaster findSupplierMasterByIdAndSuppType(String id) {
    	return suppliermasterRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addSupplierMaster(SupplierMaster suppliermaster) {
    	suppliermasterRepository.save(suppliermaster);
    	LOGGER.info("SupplierMaster added successfully " + suppliermaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSupplierMaster(String Id) {
    	suppliermasterRepository.delete(Id);
    	LOGGER.info("SupplierMaster with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSupplierMaster(SupplierMaster suppliermaster) {
    	suppliermasterRepository.save(suppliermaster);
    	LOGGER.info("SupplierMaster added successfully " + suppliermaster.toString());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public SupplierMaster save(SupplierMaster suppliermaster) {
    	suppliermasterRepository.save(suppliermaster);
    	LOGGER.info("SupplierMaster added successfully " + suppliermaster.toString());
    	return suppliermaster;
    }
    
    @Transactional
    public  SupplierMaster findBySuppCodeAndSuppType(String suppCode, String suppType) {
    	return suppliermasterRepository.findBySuppCodeAndSuppType(suppCode, suppType);
    }
    
    @Transactional
    public  List<SupplierMaster> findBySuppType(String suppType) {
    	return suppliermasterRepository.findBySuppTyp(suppType);
    }
    
    @Transactional
    public  List<SupplierMaster> findBySuppName(String suppName) {
    	return suppliermasterRepository.findBySuppName(suppName);
    }
}
