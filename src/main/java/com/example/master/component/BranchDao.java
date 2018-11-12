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

import com.example.master.entity.Branch;
import com.example.master.repository.BranchRepository;

@Component
public class BranchDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BranchRepository branchRepository;

    @Transactional(readOnly = true)
    public List<Branch> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return branchRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Branch findBranchById(Long id) {
		return branchRepository.findOne(id);
    }

    

    @Transactional(propagation = Propagation.REQUIRED)
    public void addBranch(Branch branch) {
    	branchRepository.save(branch);
    	LOGGER.info("Activity added successfully " + branch.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBranch(Long Id) {
    	branchRepository.delete(Id);
    	LOGGER.info("Branch with id " + Id + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBranch(Branch branch) {
    	branchRepository.save(branch);
    	LOGGER.info("Branch added successfully " + branch.toString());
    }
}
