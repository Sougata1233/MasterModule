package com.example.master.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.BranchDao;
import com.example.master.dto.BankDTO;
import com.example.master.dto.BranchDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Branch;
import com.example.master.services.BranchService;


/*
 * Service implementation class for branch service
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchDao branchDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(BranchServiceImpl.class);

    /*
     * preparing branch DTO for fetching data
     */
    private BranchDTO prepareBranchDTO(Branch branchEntity) {
    	BranchDTO branchDTO = new BranchDTO();
    	branchDTO.setId(branchEntity.getId());
    	branchDTO.setBrname(branchEntity.getBrname());
    	branchDTO.setbankId(branchEntity.getbankId());
    	branchDTO.setAdd(branchEntity.getAdd());
    	branchDTO.setModBy(branchEntity.getModBy());
    	branchDTO.setModOn(branchEntity.getModOn());
    	branchDTO.setIfsc(branchEntity.getIfsc());
    	
    	try {
    		BankDTO bankDTO = new BankDTO();
    		
    		bankDTO.setId(branchEntity.getBank().getId());
    		bankDTO.setBname(branchEntity.getBank().getBname());
    		bankDTO.setLocation(branchEntity.getBank().getLocation());
    		bankDTO.setAdd(branchEntity.getBank().getAdd());
    		
    	    branchDTO.setBank(bankDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
	    return branchDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BranchService#persistBranch(com.example.master.dto.BranchDTO)
     * saving branch data to the branch master table
     */
    @Override
    public ResponseEntity<BranchDTO> persistBranch(BranchDTO branchDTO) {

	
    	Branch branchEntity = new Branch();
    	branchEntity.setBrname(branchDTO.getBrname());
    	branchEntity.setbankId(branchDTO.getbankId());
    	branchEntity.setAdd(branchDTO.getAdd());
    	branchEntity.setModBy(branchDTO.getModBy());
    	branchEntity.setModOn(Date.valueOf(LocalDate.now()));
    	branchEntity.setIfsc(branchDTO.getIfsc());
    	
    	branchDao.addBranch(branchEntity);
	return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BranchService#updateBranch(com.example.master.dto.BranchDTO)
     * updating branch master table
     */
    @Override
    public ResponseEntity<BranchDTO> updateBranch(BranchDTO branchDTO) {

	
    	Branch branchEntity = new Branch();
        branchEntity.setBrname(branchDTO.getBrname());
        branchEntity.setbankId(branchDTO.getbankId());
    	branchEntity.setAdd(branchDTO.getAdd());
    	branchEntity.setModBy(branchDTO.getModBy());
    	branchEntity.setModOn(Date.valueOf(LocalDate.now()));
    	branchEntity.setIfsc(branchDTO.getIfsc());
	   	branchEntity.setId(branchDTO.getId());
	
    	branchDao.updateBranch(branchEntity);
	return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BranchService#populateBranchList()
     * fetching all data from branch master table
     */
    @Override
    public List<BranchDTO> populateBranchList() {
	List<BranchDTO> branchDTOList=new ArrayList<BranchDTO>();
	try {
	    List<Branch> branchEntityList=branchDao.findAll()
	    								.stream()
	    								.sorted(Comparator.comparing(Branch::getBrname))
	    								.collect(Collectors.toList());
	    
	    branchEntityList.forEach(activityEntity->{
	    	branchDTOList.add(prepareBranchDTO(activityEntity));
	    });
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return branchDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BranchService#populateOneBranchDetails(java.lang.Long)
     * fetching data from branch master table by branch id
     */
    @Override
    public BranchDTO populateOneBranchDetails(Long Id) {
    	Branch branchEntity = branchDao.findBranchById(Id);
	return prepareBranchDTO(branchEntity);
    }

    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.BranchService#destroyBranch(java.lang.Long)
     * deleting data from branch master table by id
     */
    @Override
    public DeleteDTO destroyBranch(Long Id) {

	branchDao.deleteBranch(Id);
	
	DeleteDTO deleteDTO = new DeleteDTO();
	deleteDTO.setstatus(1);
	deleteDTO.setstatusCode(2000);
	deleteDTO.setmsg("Deleted successfully.");
	
	
	return deleteDTO;
    }

   
    

    
}
