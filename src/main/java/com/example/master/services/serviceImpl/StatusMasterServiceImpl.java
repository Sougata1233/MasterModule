package com.example.master.services.serviceImpl;

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

import com.example.master.component.StatusMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StatusMasterDTO;
import com.example.master.entity.StatusMaster;
import com.example.master.services.StatusMasterService;

/*
 * Service Class For StatusMaster Entity
 */
@Service
public class StatusMasterServiceImpl implements StatusMasterService {

    @Autowired
    StatusMasterDao statusmasterDao;
 
    private static final Logger LOGGER=LoggerFactory.getLogger(StatusMasterServiceImpl.class);

    /*
     * Preparing DTO For StatusMaster Entity
     */
    private StatusMasterDTO prepareStatusMasterDTO(StatusMaster statusmasterEntity) {
    	StatusMasterDTO statusmasterDTO = new StatusMasterDTO();
    	statusmasterDTO.setstatusName(statusmasterEntity.getstatusName());
    	statusmasterDTO.setId(statusmasterEntity.getId());
	
    	return statusmasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StatusMasterService#persistStatusMaster(com.example.master.dto.StatusMasterDTO)
     * 
     * Save Service For StatusMaster
     * 
     * @Param
     * 
     * StatusMasterDTO
     * 
     */
    @Override
    public ResponseEntity<StatusMasterDTO> persistStatusMaster(StatusMasterDTO statusmasterDTO) {
    	StatusMaster statusmasterEntity = new StatusMaster();

    	statusmasterEntity.setstatusName(statusmasterDTO.getstatusName());
    	
    	statusmasterDao.addStatusMaster(statusmasterEntity);
	
    	return new ResponseEntity<StatusMasterDTO>(statusmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StatusMasterService#updateStatusMaster(com.example.master.dto.StatusMasterDTO)
     * 
     * Update Service For StatusMaster Entity
     * 
     * @Param
     * 
     * StatusMasterDTO
     * 
     */
    @Override
    public ResponseEntity<StatusMasterDTO> updateStatusMaster(StatusMasterDTO statusmasterDTO) {
    	StatusMaster statusmasterEntity = new StatusMaster();

    	statusmasterEntity.setstatusName(statusmasterDTO.getstatusName());
    	statusmasterEntity.setId(statusmasterDTO.getId());

	
    	statusmasterDao.updateStatusMaster(statusmasterEntity);
	
    	return new ResponseEntity<StatusMasterDTO>(statusmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StatusMasterService#populateStatusMasterList()
     * 
     * Fetching All StatusMaster
     * 
     */
    @Override
    public List<StatusMasterDTO> populateStatusMasterList() {
		List<StatusMasterDTO> statusmasterDTOList=new ArrayList<StatusMasterDTO>();
		try {
		    List<StatusMaster> statusmasterEntityList=statusmasterDao.findAll()
		    															.stream()
		    															.sorted(Comparator
	    																		.comparing(StatusMaster::getstatusName))
		    															.collect(Collectors.toList());
		    
		    statusmasterEntityList.forEach(statusmasterEntity->{
		    	statusmasterDTOList.add(prepareStatusMasterDTO(statusmasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return statusmasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StatusMasterService#populateOneStatusMasterDetails(java.lang.Long)
     * 
     * Fetching StatusMaster By Id
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public StatusMasterDTO populateOneStatusMasterDetails(Long Id) {
    	StatusMaster statusmasterEntity = statusmasterDao.findStatusMasterById(Id);
	
    	return prepareStatusMasterDTO(statusmasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StatusMasterService#destroyStatusMaster(java.lang.Long)
     * 
     * Delete Service For StatusMaster Entity
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyStatusMaster(Long Id) {

    	statusmasterDao.deleteStatusMaster(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
