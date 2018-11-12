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

import com.example.master.component.SubmenuMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.MenuMasterDTO;
import com.example.master.dto.SubmenuMasterDTO;
import com.example.master.entity.SubmenuMaster;
import com.example.master.services.SubmenuMasterService;

/*
 * Service Class for SubmenuMaster entity
 */
@Service
public class SubmenuMasterServiceImpl implements SubmenuMasterService {

    @Autowired
    SubmenuMasterDao submenumasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(SubmenuMasterServiceImpl.class);

   /*
    * Preparing DTO For SubmenuMaster Entity
    */
    private SubmenuMasterDTO prepareSubmenuMasterDTO(SubmenuMaster submenumasterEntity) {
    	SubmenuMasterDTO submenumasterDTO = new SubmenuMasterDTO();
    	
    	submenumasterDTO.setmenuId(submenumasterEntity.getmenuId());
    	submenumasterDTO.setsubMenu(submenumasterEntity.getsubMenu());
    	submenumasterDTO.setmodBy(submenumasterEntity.getmodBy());
    	submenumasterDTO.setmodOn(submenumasterEntity.getmodOn());
		submenumasterDTO.setId(submenumasterEntity.getId());
		try {
       		MenuMasterDTO menumasterDTO = new MenuMasterDTO();

    		menumasterDTO.setmenu(submenumasterEntity.getMenuMaster().getmenu());
    		menumasterDTO.setmodby(submenumasterEntity.getMenuMaster().getmodby());
    		menumasterDTO.setmodifiedOn(submenumasterEntity.getMenuMaster().getmodifiedOn());
    		menumasterDTO.setmenuIconName(submenumasterEntity.getMenuMaster().getmenuIconName());
    		menumasterDTO.setId(submenumasterEntity.getMenuMaster().getId());
    		submenumasterDTO.setMenuMaster(menumasterDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
	    return submenumasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SubmenuMasterService#persistSubmenuMaster(com.example.master.dto.SubmenuMasterDTO)
     * 
     * Save Service For SubmenuMaster Entity
     * 
     * @param
     * 
     * SubmenuMasterDTO
     * 
     */
    @Override
    public ResponseEntity<SubmenuMasterDTO> persistSubmenuMaster(SubmenuMasterDTO submenumasterDTO) {
    	SubmenuMaster submenumasterEntity = new SubmenuMaster();

    	submenumasterEntity.setmenuId(submenumasterDTO.getmenuId());
    	submenumasterEntity.setsubMenu(submenumasterDTO.getsubMenu());
    	submenumasterEntity.setmodBy(submenumasterDTO.getmodBy());
    	submenumasterEntity.setmodOn(Date.valueOf(LocalDate.now()));
	
    	submenumasterDao.addSubmenuMaster(submenumasterEntity);
	
    	return new ResponseEntity<SubmenuMasterDTO>(submenumasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SubmenuMasterService#updateSubmenuMaster(com.example.master.dto.SubmenuMasterDTO)
     * 
     * Update Service For SubmenuMaster Entity
     * 
     * @Parma
     * 
     * SubmenuMasterDTO
     * 
     */
    @Override
    public ResponseEntity<SubmenuMasterDTO> updateSubmenuMaster(SubmenuMasterDTO submenumasterDTO) {
    	SubmenuMaster submenumasterEntity = new SubmenuMaster();

    	submenumasterEntity.setmenuId(submenumasterDTO.getmenuId());
    	submenumasterEntity.setsubMenu(submenumasterDTO.getsubMenu());
    	submenumasterEntity.setmodBy(submenumasterDTO.getmodBy());
    	submenumasterEntity.setmodOn(Date.valueOf(LocalDate.now()));
    	submenumasterEntity.setId(submenumasterDTO.getId());
	
    	submenumasterDao.updateSubmenuMaster(submenumasterEntity);
    	
    	return new ResponseEntity<SubmenuMasterDTO>(submenumasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SubmenuMasterService#populateSubmenuMasterList()
     * 
     * Fetching All SubmenuMaster
     * 
     */
    @Override
    public List<SubmenuMasterDTO> populateSubmenuMasterList() {
		List<SubmenuMasterDTO> submenumasterDTOList=new ArrayList<SubmenuMasterDTO>();
		try {
		    List<SubmenuMaster> submenumasterEntityList=submenumasterDao.findAll()
		    															.stream()
		    															.sorted(Comparator
		    																	.comparing(SubmenuMaster::getsubMenu))
		    															.collect(Collectors.toList());
		    
		    submenumasterEntityList.forEach(submenumasterEntity->{
		    	submenumasterDTOList.add(prepareSubmenuMasterDTO(submenumasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return submenumasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SubmenuMasterService#populateOneSubmenuMasterDetails(java.lang.Long)
     * 
     * Fetching SubmenuMaster By Id
     * 
     * @Param 
     * 
     * Long Id
     * 
     */
    @Override
    public SubmenuMasterDTO populateOneSubmenuMasterDetails(Long Id) {
    	SubmenuMaster submenumasterEntity = submenumasterDao.findSubmenuMasterById(Id);
	
    	return prepareSubmenuMasterDTO(submenumasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.SubmenuMasterService#destroySubmenuMaster(java.lang.Long)
     * 
     * Delete Service For SubmenuMaster
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroySubmenuMaster(Long Id) {

    	submenumasterDao.deleteSubmenuMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
