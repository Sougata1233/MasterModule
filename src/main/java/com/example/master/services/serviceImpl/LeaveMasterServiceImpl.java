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

import com.example.master.component.LeaveMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.LeaveMasterDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.LeaveMaster;
import com.example.master.services.LeaveMasterService;

/*
 * Service Class For LeaveMaster
 */
@Service
public class LeaveMasterServiceImpl implements LeaveMasterService {

    @Autowired
    LeaveMasterDao leavemasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(LeaveMasterServiceImpl.class);
    
    /*
     * Preparing DTO for LeaveMaster Entity
     */
    private LeaveMasterDTO prepareLeaveMasterDTO(LeaveMaster leavemasterEntity) {
    	LeaveMasterDTO leavemasterDTO = new LeaveMasterDTO();
    	leavemasterDTO.setleaveType(leavemasterEntity.getleaveType());
    	leavemasterDTO.setisCarryFwd(leavemasterEntity.getisCarryFwd());
    	leavemasterDTO.setmaxNumInAYear(leavemasterEntity.getmaxNumInAYear());
    	leavemasterDTO.setCarrayFwdLimit(leavemasterEntity.getCarrayFwdLimit());
    	leavemasterDTO.setvalidity(leavemasterEntity.getvalidity());
    	leavemasterDTO.setstatus(leavemasterEntity.getstatus());
    	leavemasterDTO.setmodby(leavemasterEntity.getmodby());
    	leavemasterDTO.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	leavemasterDTO.setcreatedBy(leavemasterEntity.getcreatedBy());
    	leavemasterDTO.setcreatedOn(leavemasterEntity.getcreatedOn());
    	leavemasterDTO.setlocationId(leavemasterEntity.getlocationId());
    	try {
    		LocationMasterDTO locmasDTO = new LocationMasterDTO();

    		locmasDTO.setlocationArea(leavemasterEntity.getLocationMaster().getlocationArea());
    		locmasDTO.setlocationCity(leavemasterEntity.getLocationMaster().getlocationCity());
    		locmasDTO.setlocationState(leavemasterEntity.getLocationMaster().getlocationState());
    		locmasDTO.setlocationCountry(leavemasterEntity.getLocationMaster().getlocationCountry());
    		locmasDTO.setlocationPin(leavemasterEntity.getLocationMaster().getlocationPin());
    		locmasDTO.setmodby(leavemasterEntity.getLocationMaster().getmodby());
    		locmasDTO.setmodifiedOn(leavemasterEntity.getLocationMaster().getmodifiedOn());
    		locmasDTO.setcreatedBy(leavemasterEntity.getLocationMaster().getcreatedBy());
    		locmasDTO.setcreatedOn(leavemasterEntity.getLocationMaster().getcreatedOn());
    		locmasDTO.setId(leavemasterEntity.getLocationMaster().getId());
    		leavemasterDTO.setLocationMaster(locmasDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	leavemasterDTO.setId(leavemasterEntity.getId());

    	return leavemasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LeaveMasterService#persistLeaveMaster(com.example.master.dto.LeaveMasterDTO)
     * 
     * Save Service For LeaveMaster Entity
     * 
     * @Param
     * 
     * LeaveMasterDTO
     * 
     */
    @Override
    public ResponseEntity<LeaveMasterDTO> persistLeaveMaster(LeaveMasterDTO leavemasterDTO) {
		    
    		LeaveMaster leavemasterEntity = new LeaveMaster();
    		
			leavemasterEntity.setleaveType(leavemasterDTO.getleaveType());
			leavemasterEntity.setisCarryFwd(leavemasterDTO.getisCarryFwd());
			leavemasterEntity.setmaxNumInAYear(leavemasterDTO.getmaxNumInAYear());
			leavemasterEntity.setCarrayFwdLimit(leavemasterDTO.getCarrayFwdLimit());
			leavemasterEntity.setvalidity(leavemasterDTO.getvalidity());
			leavemasterEntity.setstatus(leavemasterDTO.getstatus());
			leavemasterEntity.setmodby(leavemasterDTO.getmodby());
			leavemasterEntity.setmodifiedOn(leavemasterDTO.getmodifiedOn());
			leavemasterEntity.setcreatedBy(leavemasterDTO.getcreatedBy());
			leavemasterEntity.setcreatedOn(leavemasterDTO.getcreatedOn());
			leavemasterEntity.setlocationId(leavemasterDTO.getlocationId());
			
			leavemasterDao.addLeaveMaster(leavemasterEntity);
			
		return new ResponseEntity<LeaveMasterDTO>(leavemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LeaveMasterService#updateLeaveMaster(com.example.master.dto.LeaveMasterDTO)
     * 
     * Update Service For LeaveMaster Entity
     * 
     * @Param
     * 
     * LeaveMasterDTO
     * 
     */
    @Override
    public ResponseEntity<LeaveMasterDTO> updateLeaveMaster(LeaveMasterDTO leavemasterDTO) {
		LeaveMaster leavemasterEntity = new LeaveMaster();
	
		leavemasterEntity.setleaveType(leavemasterDTO.getleaveType());
		leavemasterEntity.setisCarryFwd(leavemasterDTO.getisCarryFwd());
		leavemasterEntity.setmaxNumInAYear(leavemasterDTO.getmaxNumInAYear());
		leavemasterEntity.setCarrayFwdLimit(leavemasterDTO.getCarrayFwdLimit());
		leavemasterEntity.setvalidity(leavemasterDTO.getvalidity());
		leavemasterEntity.setstatus(leavemasterDTO.getstatus());
		leavemasterEntity.setmodby(leavemasterDTO.getmodby());
		leavemasterEntity.setmodifiedOn(leavemasterDTO.getmodifiedOn());
		leavemasterEntity.setcreatedBy(leavemasterDTO.getcreatedBy());
		leavemasterEntity.setcreatedOn(leavemasterDTO.getcreatedOn());
		leavemasterEntity.setlocationId(leavemasterDTO.getlocationId());
		leavemasterEntity.setId(leavemasterDTO.getId());
	
		leavemasterDao.updateLeaveMaster(leavemasterEntity);
		
		return new ResponseEntity<LeaveMasterDTO>(leavemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LeaveMasterService#populateLeaveMasterList()
     * 
     * Fetching All LeaveMaster Entity
     * 
     */
    @Override
    public List<LeaveMasterDTO> populateLeaveMasterList() {
		List<LeaveMasterDTO> leavemasterDTOList=new ArrayList<LeaveMasterDTO>();
		try {
		    List<LeaveMaster> leavemasterEntityList=leavemasterDao.findAll()
														    		.stream()
														    		.sorted(Comparator.comparing(LeaveMaster::getleaveType))
														    		.collect(Collectors.toList());
		    
		    leavemasterEntityList.forEach(leavemasterEntity->{
		    	leavemasterDTOList.add(prepareLeaveMasterDTO(leavemasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return leavemasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LeaveMasterService#populateOneLeaveMasterDetails(java.lang.Long)
     * 
     * Fetching LeaveMaster By Leave ID
     * 
     * @Param
     * 
     * Long leaveId
     * 
     */
    @Override
    public LeaveMasterDTO populateOneLeaveMasterDetails(Long leaveId) {
    	LeaveMaster leavemasterEntity = leavemasterDao.findLeaveMasterById(leaveId);
	
    	return prepareLeaveMasterDTO(leavemasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LeaveMasterService#destroyLeaveMaster(java.lang.Long)
     * 
     * Delete Service For LeaveMaster Entity
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyLeaveMaster(Long Id) {

    	leavemasterDao.deleteLeaveMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
