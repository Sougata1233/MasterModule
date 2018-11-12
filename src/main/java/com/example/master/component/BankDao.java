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

import com.example.master.entity.Bank;
import com.example.master.repository.BankRepository;


@Component
public class BankDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BankRepository bankRepository;

    @Transactional(readOnly = true)
    public List<Bank> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return bankRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Bank findBankById(Long id) {
    	return bankRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addBank(Bank bank) {
    	bankRepository.save(bank);
    	LOGGER.info("Bank added successfully " + bank.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBank(Long Id) {
    	bankRepository.delete(Id);
    	LOGGER.info("Bank with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBank(Bank bank) {
    	bankRepository.save(bank);
    	LOGGER.info("Bank added successfully " + bank.toString());
    }
}
