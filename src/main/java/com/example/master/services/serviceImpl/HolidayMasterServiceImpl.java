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

import com.example.master.component.HolidayMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.HolidayMasterDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.entity.HolidayMaster;
import com.example.master.services.HolidayMasterService;

/*
 * Service Class For HolidayMaster
 */
@Service
public class HolidayMasterServiceImpl implements HolidayMasterService {

    @Autowired
    HolidayMasterDao holidaymasterDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(HolidayMasterServiceImpl.class);

   /*
    * Preparing DTO For All GET Methods
    */
    private HolidayMasterDTO prepareHolidayMasterDTO(HolidayMaster holidaymasterEntity) {
    	HolidayMasterDTO holidaymasterDTO = new HolidayMasterDTO();
    	holidaymasterDTO.setholiday(holidaymasterEntity.getholiday());
    	holidaymasterDTO.setdescription(holidaymasterEntity.getdescription());
    	holidaymasterDTO.setholidayTyp(holidaymasterEntity.getholidayTyp());
    	holidaymasterDTO.setlocationId(holidaymasterEntity.getlocationId());
    	holidaymasterDTO.setholidayYr(holidaymasterEntity.getholidayYr());
    	holidaymasterDTO.setmodby(holidaymasterEntity.getmodby());
    	holidaymasterDTO.setmodifiedOn(holidaymasterEntity.getmodifiedOn());
    	holidaymasterDTO.setcreatedby(holidaymasterEntity.getcreatedby());
    	holidaymasterDTO.setcreatedOn(holidaymasterEntity.getcreatedOn());
		holidaymasterDTO.setId(holidaymasterEntity.getId());
    	try {
    		LocationMasterDTO locationmasterDTO = new LocationMasterDTO();

    		locationmasterDTO.setlocationArea(holidaymasterEntity.getLocationMaster().getlocationArea());
    		locationmasterDTO.setId(holidaymasterEntity.getLocationMaster().getId());
    		locationmasterDTO.setlocationCity(holidaymasterEntity.getLocationMaster().getlocationCity());
    		locationmasterDTO.setlocationState(holidaymasterEntity.getLocationMaster().getlocationState());
    		locationmasterDTO.setlocationCountry(holidaymasterEntity.getLocationMaster().getlocationCountry());
    		locationmasterDTO.setlocationPin(holidaymasterEntity.getLocationMaster().getlocationPin());
    		locationmasterDTO.setmodby(holidaymasterEntity.getLocationMaster().getmodby());
    		locationmasterDTO.setmodifiedOn(holidaymasterEntity.getLocationMaster().getmodifiedOn());
    		locationmasterDTO.setcreatedBy(holidaymasterEntity.getLocationMaster().getcreatedBy());
    		locationmasterDTO.setcreatedOn(holidaymasterEntity.getLocationMaster().getcreatedOn());
    		holidaymasterDTO.setLocationMaster(locationmasterDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
	
    	return holidaymasterDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.HolidayMasterService#persistHolidayMaster(com.example.master.dto.HolidayMasterDTO)
     * 
     * Save Service For HolidayMaster Entity
     * 
     * @Param
     * 
     * HolidayMasterDTO
     * 
     */
    @Override
    public ResponseEntity<HolidayMasterDTO> persistHolidayMaster(HolidayMasterDTO holidaymasterDTO) {
		HolidayMaster holidaymasterEntity = new HolidayMaster();

		holidaymasterEntity.setholiday(holidaymasterDTO.getholiday());
		holidaymasterEntity.setdescription(holidaymasterDTO.getdescription());
		holidaymasterEntity.setholidayTyp(holidaymasterDTO.getholidayTyp());
		holidaymasterEntity.setlocationId(holidaymasterDTO.getlocationId());
		holidaymasterEntity.setholidayYr(holidaymasterDTO.getholidayYr());
		holidaymasterEntity.setmodby(holidaymasterDTO.getmodby());
		holidaymasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		holidaymasterEntity.setcreatedby(holidaymasterDTO.getcreatedby());
		holidaymasterEntity.setcreatedOn(Date.valueOf(LocalDate.now()));
		
		holidaymasterDao.addHolidayMaster(holidaymasterEntity);
		
		return new ResponseEntity<HolidayMasterDTO>(holidaymasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.HolidayMasterService#updateHolidayMaster(com.example.master.dto.HolidayMasterDTO)
     * 
     * Update Service For HolidayMaster
     * 
     * @Param 
     * 
     * HolidayMasterDTO
     * 
     */
    @Override
    public ResponseEntity<HolidayMasterDTO> updateHolidayMaster(HolidayMasterDTO holidaymasterDTO) {
    	HolidayMaster holidaymasterEntity = new HolidayMaster();

    	holidaymasterEntity.setholiday(holidaymasterDTO.getholiday());
    	holidaymasterEntity.setdescription(holidaymasterDTO.getdescription());
    	holidaymasterEntity.setholidayTyp(holidaymasterDTO.getholidayTyp());
    	holidaymasterEntity.setlocationId(holidaymasterDTO.getlocationId());
    	holidaymasterEntity.setholidayYr(holidaymasterDTO.getholidayYr());
    	holidaymasterEntity.setmodby(holidaymasterDTO.getmodby());
    	holidaymasterEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	holidaymasterEntity.setcreatedby(holidaymasterDTO.getcreatedby());
    	holidaymasterEntity.setcreatedOn(holidaymasterEntity.getcreatedOn());
		holidaymasterEntity.setId(holidaymasterDTO.getId());
	
    	holidaymasterDao.updateHolidayMaster(holidaymasterEntity);

    	return new ResponseEntity<HolidayMasterDTO>(holidaymasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.HolidayMasterService#populateHolidayMasterList()
     * 
     * Fetch All Service For HolidayMaster Entity
     * 
     */
    @Override
    public List<HolidayMasterDTO> populateHolidayMasterList() {
		List<HolidayMasterDTO> holidaymasterDTOList=new ArrayList<HolidayMasterDTO>();
		try {
		    List<HolidayMaster> holidaymasterEntityList=holidaymasterDao.findAll()
		    											.stream()
		    											.sorted(Comparator.comparing(HolidayMaster::getholiday))
		    											.collect(Collectors.toList());
		    
		    holidaymasterEntityList.forEach(holidaymasterEntity->{
		    	holidaymasterDTOList.add(prepareHolidayMasterDTO(holidaymasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return holidaymasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.HolidayMasterService#populateOneHolidayMasterDetails(java.lang.Long)
     * 
     * Fetching HolidayMaster Entity By Id
     * 
     * @Param
     * 
     * Long ID
     * 
     */
    @Override
    public HolidayMasterDTO populateOneHolidayMasterDetails(Long Id) {
    	HolidayMaster holidaymasterEntity = holidaymasterDao.findHolidayMasterById(Id);
	
    	return prepareHolidayMasterDTO(holidaymasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.HolidayMasterService#destroyHolidayMaster(java.lang.Long)
     * 
     * Delete Service For HolidayMaster
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyHolidayMaster(Long Id) {

    	holidaymasterDao.deleteHolidayMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
