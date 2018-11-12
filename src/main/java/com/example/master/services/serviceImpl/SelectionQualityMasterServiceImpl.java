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

import com.example.master.component.SelectionQualityMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.SelectionQualityMasterDTO;
import com.example.master.entity.SelectionQualityMaster;
import com.example.master.services.SelectionQualityMasterService;

/*
 * Service Class For SelectionQualityMaster Entity
 */
@Service
public class SelectionQualityMasterServiceImpl implements SelectionQualityMasterService {

    @Autowired
    SelectionQualityMasterDao selectionqualitymasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(SelectionQualityMasterServiceImpl.class);

   /*
    * Preparing DTO For SelectionQualityMaster Entity
    */
    private SelectionQualityMasterDTO prepareSelectionQualityMasterDTO(SelectionQualityMaster selectionqualitymasterEntity) {
    	SelectionQualityMasterDTO selectionqualitymasterDTO = new SelectionQualityMasterDTO();
    	
    	selectionqualitymasterDTO.setquality(selectionqualitymasterEntity.getquality());
    	selectionqualitymasterDTO.setId(selectionqualitymasterEntity.getId());
	
	    return selectionqualitymasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SelectionQualityMasterService#persistSelectionQualityMaster(com.example.master.dto.SelectionQualityMasterDTO)
     * 
     * Save Service For SelectionQualityMaster
     * 
     */
    @Override
    public ResponseEntity<SelectionQualityMasterDTO> 
    							persistSelectionQualityMaster(SelectionQualityMasterDTO selectionqualitymasterDTO) {
    	SelectionQualityMaster selectionqualitymasterEntity = new SelectionQualityMaster();
    	
    	selectionqualitymasterEntity.setquality(selectionqualitymasterDTO.getquality());
	
    	selectionqualitymasterDao.addSelectionQualityMaster(selectionqualitymasterEntity);
	
    	return new ResponseEntity<SelectionQualityMasterDTO>(selectionqualitymasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SelectionQualityMasterService#updateSelectionQualityMaster(com.example.master.dto.SelectionQualityMasterDTO)
     * 
     * Update Service For SelectionQualityMaster
     * 
     *  @param
     *  
     *  SelectionQualityMasterDTO
     * 
     */
    @Override
    public ResponseEntity<SelectionQualityMasterDTO> 
    								updateSelectionQualityMaster(SelectionQualityMasterDTO selectionqualitymasterDTO) {
    	SelectionQualityMaster selectionqualitymasterEntity = new SelectionQualityMaster();

    	selectionqualitymasterEntity.setquality(selectionqualitymasterDTO.getquality());
    	selectionqualitymasterEntity.setId(selectionqualitymasterDTO.getId());

	
    	selectionqualitymasterDao.updateSelectionQualityMaster(selectionqualitymasterEntity);
	
    	return new ResponseEntity<SelectionQualityMasterDTO>(selectionqualitymasterDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SelectionQualityMasterService#populateSelectionQualityMasterList()
     * 
     * Fetching All SelectionQualityMaster
     * 
     */
    @Override
    public List<SelectionQualityMasterDTO> populateSelectionQualityMasterList() {
		List<SelectionQualityMasterDTO> selectionqualitymasterDTOList=new ArrayList<SelectionQualityMasterDTO>();
		try {
		    List<SelectionQualityMaster> selectionqualitymasterEntityList=
		    									selectionqualitymasterDao.findAll()
		    															 .stream()
		    															 .sorted(Comparator
		    																	 .comparing(SelectionQualityMaster::getquality))
		    															 .collect(Collectors.toList());
		    
		    selectionqualitymasterEntityList.forEach(selectionqualitymasterEntity->{
		    	selectionqualitymasterDTOList.add(prepareSelectionQualityMasterDTO(selectionqualitymasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return selectionqualitymasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SelectionQualityMasterService#populateOneSelectionQualityMasterDetails(java.lang.Long)
     * 
     * Fetching SelectionQualityMaster By Id
     * 
     */
    @Override
    public SelectionQualityMasterDTO populateOneSelectionQualityMasterDetails(Long Id) {
    	SelectionQualityMaster selectionqualitymasterEntity = 
    											selectionqualitymasterDao.findSelectionQualityMasterById(Id);
	
    	return prepareSelectionQualityMasterDTO(selectionqualitymasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SelectionQualityMasterService#destroyScmIndentTypeMaster(java.lang.Long)
     * 
     * Delete Service For SelectionQualityMaster Entity
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyScmIndentTypeMaster(Long Id) {

    	selectionqualitymasterDao.deleteSelectionQualityMaster(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
