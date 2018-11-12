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

import com.example.master.component.LocationMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.LocationMaster;
import com.example.master.services.LocationMasterService;

/*
 * Service Class For LocationMaster Entity
 */
@Service
public class LocationMasterServiceImpl implements LocationMasterService {

    @Autowired
    LocationMasterDao locationmasterDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(LocationMasterServiceImpl.class);

    /*
     * Preparing DTO for LocationMaster Entity
     */
    private LocationMasterDTO prepareLocationMasterDTO(LocationMaster locationmasterEntity) {
    	LocationMasterDTO locationmasterDTO = new LocationMasterDTO();
    
    	locationmasterDTO.setlocationArea(locationmasterEntity.getlocationArea());
    	locationmasterDTO.setlocationCity(locationmasterEntity.getlocationCity());
		locationmasterDTO.setlocationState(locationmasterEntity.getlocationState());
    	locationmasterDTO.setlocationCountry(locationmasterEntity.getlocationCountry());
    	locationmasterDTO.setlocationPin(locationmasterEntity.getlocationPin());
    	locationmasterDTO.setmodby(locationmasterEntity.getmodby());
    	locationmasterDTO.setmodifiedOn(locationmasterEntity.getmodifiedOn());
    	locationmasterDTO.setcreatedBy(locationmasterEntity.getcreatedBy());
    	locationmasterDTO.setcreatedOn(locationmasterEntity.getcreatedOn());
    	locationmasterDTO.setId(locationmasterEntity.getId());
	
	    return locationmasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LocationMasterService#persistLocationMaster(com.example.master.dto.LocationMasterDTO)
     * 
     * Save Service For LocationMaster Entity
     * 
     * @Param
     * 
     * LocationMasterDTO
     * 
     */
    @Override
    public ResponseEntity<LocationMasterDTO> persistLocationMaster(LocationMasterDTO locationmasterDTO) {
    	LocationMaster locationmasterEntity = new LocationMaster();

    	locationmasterEntity.setlocationArea(locationmasterDTO.getlocationArea());
    	locationmasterEntity.setlocationCity(locationmasterDTO.getlocationCity());
    	locationmasterEntity.setlocationState(locationmasterDTO.getlocationState());
    	locationmasterEntity.setlocationCountry(locationmasterDTO.getlocationCountry());
    	locationmasterEntity.setlocationPin(locationmasterDTO.getlocationPin());
    	locationmasterEntity.setmodby(locationmasterDTO.getmodby());
    	locationmasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	locationmasterEntity.setcreatedBy(locationmasterDTO.getcreatedBy());
    	locationmasterEntity.setcreatedOn(Date.valueOf(LocalDate.now()));
    	
    	locationmasterDao.addLocationMaster(locationmasterEntity);
	
    	return new ResponseEntity<LocationMasterDTO>(locationmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LocationMasterService#updateLeaveMaster(com.example.master.dto.LocationMasterDTO)
     * 
     * Update Service For LocationMaster Entity
     * 
     * @Param
     * 
     * LocationMasterDTO
     * 
     */
    @Override
    public ResponseEntity<LocationMasterDTO> updateLeaveMaster(LocationMasterDTO locationmasterDTO) {
    	LocationMaster locationmasterEntity = new LocationMaster();

    	locationmasterEntity.setlocationArea(locationmasterDTO.getlocationArea());
    	locationmasterEntity.setlocationCity(locationmasterDTO.getlocationCity());
    	locationmasterEntity.setlocationState(locationmasterDTO.getlocationState());
    	locationmasterEntity.setlocationCountry(locationmasterDTO.getlocationCountry());
    	/*String pin = String.valueOf(locationmasterDTO.getlocationPin());
		if(pin!=null) {
			if (pin.matches(".*\\d+.*")) {
				if(pin.length()==6) {
					locationmasterEntity.setlocationPin(locationmasterDTO.getlocationPin());
				}
			}
		}*/
    	locationmasterEntity.setlocationPin(locationmasterDTO.getlocationPin());
    	
    	locationmasterEntity.setmodby(locationmasterDTO.getmodby());
    	locationmasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	locationmasterEntity.setcreatedBy(locationmasterDTO.getcreatedBy());
    	locationmasterEntity.setcreatedOn(locationmasterEntity.getcreatedOn());
    	locationmasterEntity.setId(locationmasterDTO.getId());

	
    	locationmasterDao.updateLeaveMaster(locationmasterEntity);
	
    	return new ResponseEntity<LocationMasterDTO>(locationmasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LocationMasterService#populateLocationMasterList()
     * 
     * Fetching All LocationMaster Entity
     * 
     */
    @Override
    public List<LocationMasterDTO> populateLocationMasterList() {
		List<LocationMasterDTO> locationmasterDTOList=new ArrayList<LocationMasterDTO>();
		try {
		    List<LocationMaster> locationmasterEntityList=locationmasterDao.findAll()
		    																.stream()
		    																.sorted(Comparator.comparing(
		    																		LocationMaster::getlocationArea))
		    																.collect(Collectors.toList());
		    
		    locationmasterEntityList.forEach(locationmasterEntity->{
		    	locationmasterDTOList.add(prepareLocationMasterDTO(locationmasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return locationmasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LocationMasterService#populateOneLocationMasterDetails(java.lang.Long)
     * 
     * Fetching LocationMaster By LocationId
     * 
     * @Param
     * 
     * Long locationId
     * 
     */
    @Override
    public LocationMasterDTO populateOneLocationMasterDetails(Long locationId) {
    	LocationMaster locationmasterEntity = locationmasterDao.findLocationMasterById(locationId);
	
    	return prepareLocationMasterDTO(locationmasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.LocationMasterService#destroyLocationMaster(java.lang.Long)
     * 
     * Delete Service For LocationMaster
     * 
     * @param
     * 
     * Long locationId
     * 
     */
    @Override
    public DeleteDTO destroyLocationMaster(Long locationId) {

    	locationmasterDao.deleteLocationMaster(locationId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
