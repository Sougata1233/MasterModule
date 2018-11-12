package com.example.master.services.serviceImpl;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.master.component.WeekendDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.LocationMasterDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.dto.WeekendDTO;
import com.example.master.entity.Weekend;
import com.example.master.services.WeekendService;

/*
 * Service Class For Weekend Entity
 */
@Service
public class WeekendServiceImpl implements WeekendService {

    @Autowired
    WeekendDao weekendDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(WeekendServiceImpl.class);

    /*
     * Preparing DTO For Weekend Entity
     */
    private WeekendDTO prepareWeekendDTO(Weekend weekendEntity) {
    	WeekendDTO weekendDTO = new WeekendDTO();
    	
    	weekendDTO.setLocationId(weekendEntity.getLocationId());
    	weekendDTO.setunitId(weekendEntity.getunitId());
		weekendDTO.setWeekend1(weekendEntity.getWeekend1());
    	weekendDTO.setWeekend2(weekendEntity.getWeekend2());
    	weekendDTO.setAlterforw1(weekendEntity.getAlterforw1());
    	weekendDTO.setmodby(weekendEntity.getmodby());
    	weekendDTO.setmodifiedOn(weekendEntity.getmodifiedOn());
    	try {
    		LocationMasterDTO locmasDTO = new LocationMasterDTO();

    		locmasDTO.setlocationArea(weekendEntity.getLocationMaster().getlocationArea());
    		locmasDTO.setlocationCity(weekendEntity.getLocationMaster().getlocationCity());
    		locmasDTO.setlocationState(weekendEntity.getLocationMaster().getlocationState());
    		locmasDTO.setlocationCountry(weekendEntity.getLocationMaster().getlocationCountry());
    		locmasDTO.setlocationPin(weekendEntity.getLocationMaster().getlocationPin());
    		locmasDTO.setmodby(weekendEntity.getLocationMaster().getmodby());
    		locmasDTO.setmodifiedOn(weekendEntity.getLocationMaster().getmodifiedOn());
    		locmasDTO.setcreatedBy(weekendEntity.getLocationMaster().getcreatedBy());
    		locmasDTO.setcreatedOn(weekendEntity.getLocationMaster().getcreatedOn());
    		locmasDTO.setId(weekendEntity.getLocationMaster().getId());
    		weekendDTO.setLocationMaster(locmasDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	try {
    		OrganizationDTO organizationDTO = new OrganizationDTO();

			organizationDTO.setId(weekendEntity.getOrganization().getId());
			organizationDTO.setorgName(weekendEntity.getOrganization().getorgName());
			organizationDTO.setHierarchyId(weekendEntity.getOrganization().getHierarchyId());
			organizationDTO.setmodby(weekendEntity.getOrganization().getmodby());
			organizationDTO.setshortCode(weekendEntity.getOrganization().getshortCode());
			organizationDTO.setorgTyp(weekendEntity.getOrganization().getorgTyp());
			organizationDTO.setmodifiedOn(weekendEntity.getOrganization().getmodifiedOn());
			weekendDTO.setOrganization(organizationDTO);
		} catch (Exception e) {
		    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
		}
		weekendDTO.setId(weekendEntity.getId());
		
		return weekendDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.WeekendService#persistWeekend(com.example.master.dto.WeekendDTO)
     * 
     * Save Service For Weekend Entity
     * 
     * @Param
     * 
     * WeekendDTO
     * 
     */
    @Override
    public ResponseEntity<WeekendDTO> persistWeekend(WeekendDTO weekendDTO) {
		Weekend weekendEntity = new Weekend();

		weekendEntity.setLocationId(weekendDTO.getLocationId());
		weekendEntity.setunitId(weekendDTO.getunitId());
		weekendEntity.setWeekend1(weekendDTO.getWeekend1());
		weekendEntity.setWeekend2(weekendDTO.getWeekend2());
		weekendEntity.setAlterforw1(weekendDTO.getAlterforw1());
		weekendEntity.setmodby(weekendDTO.getmodby());
		weekendEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		
		weekendDao.addWeekend(weekendEntity);
		
		return new ResponseEntity<WeekendDTO>(weekendDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.WeekendService#updateWeekend(com.example.master.dto.WeekendDTO)
     * 
     * Update Service For Weekend Entity
     * 
     * @Param
     * 
     * WeekendDTO
     * 
     */
    @Override
    public ResponseEntity<WeekendDTO> updateWeekend(WeekendDTO weekendDTO) {
		Weekend weekendEntity = new Weekend();

		weekendEntity.setLocationId(weekendDTO.getLocationId());
		weekendEntity.setunitId(weekendDTO.getunitId());
		weekendEntity.setWeekend1(weekendDTO.getWeekend1());
		weekendEntity.setWeekend2(weekendDTO.getWeekend2());
		weekendEntity.setAlterforw1(weekendDTO.getAlterforw1());
		weekendEntity.setmodby(weekendDTO.getmodby());
		weekendEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		weekendEntity.setId(weekendDTO.getId());
	
		weekendDao.updateWeekend(weekendEntity);
		
		return new ResponseEntity<WeekendDTO>(weekendDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.WeekendService#populateWeekendList()
     * 
     * Fetching All Weekend Entity
     * 
     * 
     */
    @Override
    public List<WeekendDTO> populateWeekendList() {
		List<WeekendDTO> weekendDTOList=new ArrayList<WeekendDTO>();
		try {
		    List<Weekend> weekendEntityList=weekendDao.findAll()
		    		.stream()
		    		.sorted(Comparator.comparing(Weekend::getWeekend1))
		    		.collect(Collectors.toList());
		    
		    weekendEntityList.forEach(weekendEntity->{
		    	weekendDTOList.add(prepareWeekendDTO(weekendEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return weekendDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.WeekendService#populateOneWeekendDetails(java.lang.Long)
     * 
     * Fetching Weekend By id
     * 
     */
    @Override
    public WeekendDTO populateOneWeekendDetails(Long id) {
    	Weekend weekendEntity = weekendDao.findWeekendById(id);
	
    	return prepareWeekendDTO(weekendEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.WeekendService#destroyWeekend(java.lang.Long)
     * 
     * Delete Service for Weekend Entity
     * 
     * @Param 
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyWeekend(Long id) {

    	weekendDao.deleteWeekend(id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
