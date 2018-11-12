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

import com.example.master.component.UomMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.UomMasterDTO;
import com.example.master.entity.UomMaster;
import com.example.master.services.UomMasterService;

/*
 * Service Class For UOMMaster
 */
@Service
public class UomMasterServiceImpl implements UomMasterService {

    @Autowired
    UomMasterDao uommasterDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(UomMasterServiceImpl.class);

    /*
     * Preparing DTO For UomMaster Entity
     */
    private UomMasterDTO prepareUomMasterDTO(UomMaster uommasterEntity) {
    	UomMasterDTO uommasterDTO = new UomMasterDTO();
    
    	uommasterDTO.setuomDsc(uommasterEntity.getuomDsc());
    	uommasterDTO.setuser1(uommasterEntity.getuser1());
    	uommasterDTO.setdate1(uommasterEntity.getdate1());
    	uommasterDTO.setuser2(uommasterEntity.getuser2());
    	uommasterDTO.setdate2(uommasterEntity.getdate2());
    	uommasterDTO.setuser3(uommasterEntity.getuser3());
    	uommasterDTO.setdate3(uommasterEntity.getdate3());
    	uommasterDTO.setuser4(uommasterEntity.getuser4());
    	uommasterDTO.setdate4(uommasterEntity.getdate4());
    	uommasterDTO.setactivityFlag(uommasterEntity.getactivityFlag());
    	uommasterDTO.setmodby(uommasterEntity.getmodby());
    	uommasterDTO.setmodifiedOn(uommasterEntity.getmodifiedOn());
    	uommasterDTO.setId(uommasterEntity.getId());

	    return uommasterDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.UomMasterService#persistUomMaster(com.example.master.dto.UomMasterDTO)
     * 
     * Save Service For UomMaster
     * 
     * @Param
     * 
     * UomMasterDTO
     * 
     */
    @Override
    public ResponseEntity<UomMasterDTO> persistUomMaster(UomMasterDTO uommasterDTO) {
    	UomMaster uommasterEntity = new UomMaster();

    	uommasterEntity.setuomDsc(uommasterDTO.getuomDsc().toUpperCase());
    	uommasterEntity.setuser1(uommasterDTO.getuser1());
    	uommasterEntity.setdate1(uommasterDTO.getdate1());
    	uommasterEntity.setuser2(uommasterDTO.getuser2());
    	uommasterEntity.setdate2(uommasterDTO.getdate2());
    	uommasterEntity.setuser3(uommasterDTO.getuser3());
    	uommasterEntity.setdate3(uommasterDTO.getdate3());
    	uommasterEntity.setuser4(uommasterDTO.getuser4());
    	uommasterEntity.setdate4(uommasterDTO.getdate4());
    	uommasterEntity.setactivityFlag(uommasterDTO.getactivityFlag());
    	uommasterEntity.setmodby(uommasterDTO.getmodby());
    	uommasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	uommasterEntity.setId(uommasterDTO.getId().toUpperCase());
    	
    	uommasterDao.addUomMaster(uommasterEntity);
	
    	return new ResponseEntity<UomMasterDTO>(uommasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UomMasterService#updateUomMaster(com.example.master.dto.UomMasterDTO)
     * 
     * Update Service For UomMaster Entity
     * 
     * @Param
     * 
     * UomMasterDTO
     * 
     */
    @Override
    public ResponseEntity<UomMasterDTO> updateUomMaster(UomMasterDTO uommasterDTO) {
    	UomMaster uommasterEntity = new UomMaster();

    	uommasterEntity.setuomDsc(uommasterDTO.getuomDsc());
    	uommasterEntity.setuser1(uommasterDTO.getuser1());
    	uommasterEntity.setdate1(uommasterDTO.getdate1());
    	uommasterEntity.setuser2(uommasterDTO.getuser2());
    	uommasterEntity.setdate2(uommasterDTO.getdate2());
    	uommasterEntity.setuser3(uommasterDTO.getuser3());
    	uommasterEntity.setdate3(uommasterDTO.getdate3());
    	uommasterEntity.setuser4(uommasterDTO.getuser4());
    	uommasterEntity.setdate4(uommasterDTO.getdate4());
    	uommasterEntity.setactivityFlag(uommasterDTO.getactivityFlag());
    	uommasterEntity.setmodby(uommasterDTO.getmodby());
    	uommasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	uommasterEntity.setId(uommasterDTO.getId());
    	
    	uommasterDao.updateUomMaster(uommasterEntity);
	
    	return new ResponseEntity<UomMasterDTO>(uommasterDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.UomMasterService#populateUomMasterList()
     * 
     * Fetching All UomMaster
     * 
     */
    @Override
    public List<UomMasterDTO> populateUomMasterList() {
		List<UomMasterDTO> uommasterDTOList=new ArrayList<UomMasterDTO>();
		try {
		    List<UomMaster> uommasterEntityList=uommasterDao.findAll()
		    													.stream()
		    													.sorted(Comparator.comparing(UomMaster::getuomDsc))
		    													.collect(Collectors.toList());
		    
		    uommasterEntityList.forEach(uommasterEntity->{
		    	uommasterDTOList.add(prepareUomMasterDTO(uommasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return uommasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UomMasterService#populateOneUomMasterDetails(java.lang.String)
     * 
     * Fetching UomMaster By id
     * 
     * @param
     * 
     * String id
     * 
     */
    @Override
    public UomMasterDTO populateOneUomMasterDetails(String Id) {
    	UomMaster uommasterEntity = uommasterDao.findUomMasterById(Id);
	
    	return prepareUomMasterDTO(uommasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UomMasterService#destroyUomMaster(java.lang.String)
     * 
     * Delete Service For UomMaster Entity
     * 
     * @Param
     * 
     * String id
     * 
     */
    @Override
    public DeleteDTO destroyUomMaster(String Id) {

    	uommasterDao.deleteUomMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
