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
import org.springframework.web.bind.annotation.PathVariable;

import com.example.master.component.ApproverMasterDao;
import com.example.master.dto.ApproverMasterDTO;
import com.example.master.dto.UsergroupDTO;
import com.example.master.entity.ApproverMaster;
import com.example.master.services.ApproverMasterService;


/*
 * Service implementaion class for ApproverMaster table
 */
@Service
public class ApproverMasterServiceImpl implements ApproverMasterService {

    @Autowired
    ApproverMasterDao approvermasterDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(ApproverMasterServiceImpl.class);

    /*
     * preparing DTO for activity master table
     */
    private ApproverMasterDTO prepareApproverMasterDTO(ApproverMaster approvermasterEntity) {
    	ApproverMasterDTO approvermasterDTO = new ApproverMasterDTO();
    	
	
    	approvermasterDTO.settaskDsc(approvermasterEntity.gettaskDsc());
    	
    	approvermasterDTO.setapproval1(approvermasterEntity.getapproval1());
    	approvermasterDTO.setapproval2(approvermasterEntity.getapproval2());
    	approvermasterDTO.setapproval3(approvermasterEntity.getapproval3());
    	approvermasterDTO.setapproval4(approvermasterEntity.getapproval4());
    	approvermasterDTO.setapproval5(approvermasterEntity.getapproval5());
    	approvermasterDTO.setmodby(approvermasterEntity.getmodby());
    	approvermasterDTO.setmodifiedOn(approvermasterEntity.getmodifiedOn());
    	
	
    	approvermasterDTO.setId(approvermasterEntity.getId());
    	try {
    		UsergroupDTO userDTO = new UsergroupDTO();

    		userDTO.setUsrgrpName(approvermasterEntity.getusergrp1().getUsrgrpName());
    		userDTO.setId(approvermasterEntity.getusergrp1().getId());

    		approvermasterDTO.setusergrp1(userDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	
    	
    	try {
    		UsergroupDTO userDTO = new UsergroupDTO();

    		userDTO.setUsrgrpName(approvermasterEntity.getusergrp2().getUsrgrpName());
    		userDTO.setId(approvermasterEntity.getusergrp2().getId());
    		
    		approvermasterDTO.setusergrp2(userDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	
    	try {
    		UsergroupDTO userDTO = new UsergroupDTO();

    		userDTO.setUsrgrpName(approvermasterEntity.getusergrp3().getUsrgrpName());
    		userDTO.setId(approvermasterEntity.getusergrp3().getId());

    		approvermasterDTO.setusergrp3(userDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	
    	
    	try {
    		UsergroupDTO userDTO = new UsergroupDTO();

    		userDTO.setUsrgrpName(approvermasterEntity.getusergrp4().getUsrgrpName());
    		userDTO.setId(approvermasterEntity.getusergrp4().getId());
    		approvermasterDTO.setusergrp4(userDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	
    	try {
    		UsergroupDTO userDTO = new UsergroupDTO();

    		userDTO.setUsrgrpName(approvermasterEntity.getusergrp5().getUsrgrpName());
    		userDTO.setId(approvermasterEntity.getusergrp5().getId());

    		approvermasterDTO.setusergrp5(userDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}

	    return approvermasterDTO;
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ApproverMasterService#persistApproverMaster(com.example.master.dto.ApproverMasterDTO)
     * saving data to the approver master table
     */
    @Override
    public ResponseEntity<ApproverMasterDTO> persistApproverMaster(ApproverMasterDTO approvermasterDTO) {

	

    	ApproverMaster approvermasterEntity = new ApproverMaster();
        approvermasterEntity.settaskDsc(approvermasterDTO.gettaskDsc());
        
        Long userGrp=approvermasterDTO.getuserGroup();
        Long approvalLabel=approvermasterDTO.getapprovalLabel();
        
        
        if(approvalLabel==1){
        	approvermasterEntity.setapproval1(userGrp);
        	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
        	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
        	approvermasterDao.addApproverMaster(approvermasterEntity);
    	
        	approvermasterEntity.setId(approvermasterDTO.getId());
        }else if(approvalLabel==2){
        	System.out.println("userGrp"+userGrp);
        	System.out.println("approverlabel 2");
        	System.out.println("update");
        	approvermasterEntity.setapproval2(userGrp);
        	approvermasterEntity.setId(approvermasterDTO.getId());
        	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
        	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
        	approvermasterDao.updateApproverMaster(approvermasterEntity);
        }else if(approvalLabel==3){
        	approvermasterEntity.setapproval3(userGrp);
        	approvermasterEntity.setId(approvermasterDTO.getId());
        	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
        	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
        	approvermasterDao.updateApproverMaster(approvermasterEntity);
        }else if(approvalLabel==4){ 
        	approvermasterEntity.setapproval4(userGrp);
        	approvermasterEntity.setId(approvermasterDTO.getId());
        	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
        	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
        	approvermasterDao.updateApproverMaster(approvermasterEntity);
        }else if(approvalLabel==5){	
        	approvermasterEntity.setapproval5(userGrp);
        	approvermasterEntity.setId(approvermasterDTO.getId());
        	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
        	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
        	approvermasterDao.updateApproverMaster(approvermasterEntity);
        }else{}
        
        
    	/*
    	approvermasterEntity.setuser1(approvermasterDTO.getuser1());
    	approvermasterEntity.setuser2(approvermasterDTO.getuser2());
    	approvermasterEntity.setuser3(approvermasterDTO.getuser3());
    	approvermasterEntity.setuser4(approvermasterDTO.getuser4());
    	approvermasterEntity.setuser5(approvermasterDTO.getuser5());
    	
    	*/
    return new ResponseEntity<ApproverMasterDTO>(approvermasterDTO, HttpStatus.CREATED);

    }
    

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ApproverMasterService#updateApproverMaster(com.example.master.dto.ApproverMasterDTO)
     * updating data of approver master table
     */
    @Override
    public ResponseEntity<ApproverMasterDTO> updateApproverMaster(ApproverMasterDTO approvermasterDTO) {

	
	
    	ApproverMaster approvermasterEntity = new ApproverMaster();
        approvermasterEntity.settaskDsc(approvermasterDTO.gettaskDsc());
    	
    	approvermasterEntity.setapproval1(approvermasterDTO.getapproval1());
    	approvermasterEntity.setapproval2(approvermasterDTO.getapproval2());
    	approvermasterEntity.setapproval3(approvermasterDTO.getapproval3());
    	approvermasterEntity.setapproval4(approvermasterDTO.getapproval4());
    	approvermasterEntity.setapproval5(approvermasterDTO.getapproval5());
    	approvermasterEntity.setmodby(approvermasterDTO.getmodby());
    	approvermasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
    	approvermasterEntity.setId(approvermasterDTO.getId());
    	
	System.out.println("ApproverMaster Entity to send to dao is " + approvermasterEntity);
	approvermasterDao.updateApproverMaster(approvermasterEntity);
	return new ResponseEntity<ApproverMasterDTO>(approvermasterDTO, HttpStatus.CREATED);

    }
    

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ApproverMasterService#populateApproverMasterList()
     * fetching all the datas from approver master table
     */
    @Override
    public List<ApproverMasterDTO> populateApproverMasterList() {
	List<ApproverMasterDTO> approvermasterDTOList=new ArrayList<ApproverMasterDTO>();
	try {
	    List<ApproverMaster> approvermasterEntityList=approvermasterDao.findAll()
	    												.stream()
	    												.sorted(Comparator.comparing(ApproverMaster::gettaskDsc))
	    												.collect(Collectors.toList());
	    
	    approvermasterEntityList.forEach(approvermasterEntity->{
	    	approvermasterDTOList.add(prepareApproverMasterDTO(approvermasterEntity));
	    });
	    
	   
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return approvermasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ApproverMasterService#populateOneApproverMasterDetails(java.lang.Long)
     * fetching data from approver master details by id
     */
    @Override
    public ApproverMasterDTO populateOneApproverMasterDetails(Long Id) {
    	ApproverMaster approvermasterEntity = approvermasterDao.findApproverMasterById(Id);
	return prepareApproverMasterDTO(approvermasterEntity);
    }

    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ApproverMasterService#destroyApproverMaster(java.lang.Long)
     * deleting data from approver master table by id
     */
    @Override
    public void destroyApproverMaster(@PathVariable("Id") Long Id) {

    	approvermasterDao.deleteApproverMaster(Id);
    }

   
    

    
}
