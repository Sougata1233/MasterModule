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
import org.springframework.web.bind.annotation.PathVariable;

import com.example.master.component.ShiftMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ShiftMasterDTO;
import com.example.master.entity.ShiftMaster;
import com.example.master.services.ShiftMasterService;

/*
 * Service Class For ShiftMaster Entity
 */
@Service
public class ShiftMasterServiceImpl implements ShiftMasterService {

    @Autowired
    ShiftMasterDao shiftmasterDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(ShiftMasterServiceImpl.class);

    /*
     * Preparing DTO For ShiftMaster Entity
     */
    private ShiftMasterDTO prepareShiftMasterDTO(ShiftMaster shiftmasterEntity) {
    	ShiftMasterDTO shiftmasterDTO = new ShiftMasterDTO();
    	shiftmasterDTO.setshiftName(shiftmasterEntity.getshiftName());
    	shiftmasterDTO.setworkingHours(shiftmasterEntity.getworkingHours());
		shiftmasterDTO.setId(shiftmasterEntity.getId());
	
		return shiftmasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ShiftMasterService#persistShiftMaster(com.example.master.dto.ShiftMasterDTO)
     * 
     * Save Service For ShiftMaster Entity
     * 
     * @Param
     * 
     * ShiftMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ShiftMasterDTO> persistShiftMaster(ShiftMasterDTO shiftmasterDTO) {
    	ShiftMaster shiftmasterEntity = new ShiftMaster();

    	shiftmasterEntity.setshiftName(shiftmasterDTO.getshiftName());
    	shiftmasterEntity.setworkingHours(shiftmasterDTO.getworkingHours());
	
    	shiftmasterDao.addShiftMaster(shiftmasterEntity);
	
    	return new ResponseEntity<ShiftMasterDTO>(shiftmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ShiftMasterService#updateShiftMaster(com.example.master.dto.ShiftMasterDTO)
     * 
     * Update Service For ShiftMaster Entity
     * 
     * @Param
     * 
     * ShiftMasterDTO
     * 
     */
    @Override
    public ResponseEntity<ShiftMasterDTO> updateShiftMaster(ShiftMasterDTO shiftmasterDTO) {
    	ShiftMaster shiftmasterEntity = new ShiftMaster();

    	shiftmasterEntity.setshiftName(shiftmasterDTO.getshiftName());
    	shiftmasterEntity.setworkingHours(shiftmasterDTO.getworkingHours());
    	shiftmasterEntity.setId(shiftmasterDTO.getId());

	
    	shiftmasterDao.updateShiftMaster(shiftmasterEntity);
	
    	return new ResponseEntity<ShiftMasterDTO>(shiftmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ShiftMasterService#populateShiftMasterList()
     * 
     * Fetching All ShiftMaster Entity
     * 
     */
    @Override
    public List<ShiftMasterDTO> populateShiftMasterList() {
		List<ShiftMasterDTO> shiftmasterDTOList=new ArrayList<ShiftMasterDTO>();
		try {
		    List<ShiftMaster> shiftmasterEntityList=shiftmasterDao.findAll()
		    														.stream()
		    														.sorted(Comparator.comparing(ShiftMaster::getshiftName))
		    														.collect(Collectors.toList());
		    
		    shiftmasterEntityList.forEach(shiftmasterEntity->{
		    	shiftmasterDTOList.add(prepareShiftMasterDTO(shiftmasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return shiftmasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ShiftMasterService#populateOneShiftMasterDetails(java.lang.Long)
     * 
     * Fetching ShiftMaster By Id
     * 
     */
    @Override
    public ShiftMasterDTO populateOneShiftMasterDetails(@PathVariable("Id") Long Id) {
    	ShiftMaster shiftmasterEntity = shiftmasterDao.findShiftMasterById(Id);
	
    	return prepareShiftMasterDTO(shiftmasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ShiftMasterService#destroyShiftMaster(java.lang.Long)
     * 
     * Delete Service For ShiftMaster Entity
     * 
     * @Param
     * 
     * Long ID
     * 
     */
    @Override
    public DeleteDTO destroyShiftMaster(Long Id) {

    	shiftmasterDao.deleteShiftMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
