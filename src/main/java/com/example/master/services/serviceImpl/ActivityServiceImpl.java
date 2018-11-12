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

import com.example.master.component.ActivityDao;
import com.example.master.dto.ActivityDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Activity;
import com.example.master.services.ActivityService;


/*
 * Service implementation class for activity table
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDao activityDao;

   
    
    private static final Logger LOGGER=LoggerFactory.getLogger(ActivityServiceImpl.class);

   
    /*
     * populating activity DTO for fetching data from the table
     */
    private ActivityDTO prepareActivityDTO(Activity activityEntity) {
    	ActivityDTO activityDTO = new ActivityDTO();
    	activityDTO.setActivityName(activityEntity.getActivityName());
    	activityDTO.setActivityStartDate(activityEntity.getActivityStartDate());
	
    	activityDTO.setActivityEndDate(activityEntity.getActivityEndDate());
    	activityDTO.setActivityStatus(activityEntity.getActivityStatus());
    	activityDTO.setmodby(activityEntity.getmodby());
    	activityDTO.setmodifiedOn(activityEntity.getmodifiedOn());
    	
	
	    activityDTO.setId(activityEntity.getId());
	
	

	    return activityDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ActivityService#persistUser(com.example.master.dto.ActivityDTO)
     * saving activity entity data to the table
     */
    @Override
    public ResponseEntity<ActivityDTO> persistUser(ActivityDTO activityDTO) {

	System.out.println(
		"activity dto in persistence layer to be set is " + activityDTO.toString() + "`" + activityDTO.getActivityName());

	Activity activityEntity = new Activity();
	activityEntity.setActivityName(activityDTO.getActivityName());
	activityEntity.setActivityStartDate(activityDTO.getActivityStartDate());
	
	
	activityEntity.setActivityEndDate(activityDTO.getActivityEndDate());
	activityEntity.setActivityStatus(activityDTO.getActivityStatus());
	activityEntity.setmodby(activityDTO.getmodby());
	activityEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
	

	activityDao.addActivity(activityEntity);
	return new ResponseEntity<ActivityDTO>(activityDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ActivityService#updateActivity(com.example.master.dto.ActivityDTO)
     * updating activity table in the database
     */
    @Override
    public ResponseEntity<ActivityDTO> updateActivity(ActivityDTO activityDTO) {

	System.out.println(
		"user dto in persistence layer to be updated is " + activityDTO.toString() + "`" + activityDTO.getActivityName());
	
	Activity activityEntity = new Activity();
	activityEntity.setActivityName(activityDTO.getActivityName());
	activityEntity.setActivityStartDate(activityDTO.getActivityStartDate());
	
	
	activityEntity.setActivityEndDate(activityDTO.getActivityEndDate());
	activityEntity.setActivityStatus(activityDTO.getActivityStatus());
	activityEntity.setmodby(activityDTO.getmodby());
	activityEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
	
	activityEntity.setId(activityDTO.getId());

	System.out.println("activity Entity to send to dao is " + activityEntity);
	activityDao.updateActivity(activityEntity);
	return new ResponseEntity<ActivityDTO>(activityDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ActivityService#populateActivityList()
     * fetching all the datas from activity table 
     */
    @Override
    public List<ActivityDTO> populateActivityList() {
	List<ActivityDTO> activityDTOList=new ArrayList<ActivityDTO>();
	try {
	    List<Activity> activityEntityList=activityDao.findAll()
	    									.stream()
	    									.sorted(Comparator.comparing(Activity::getActivityName))
	    									.collect(Collectors.toList());
	    
	    activityEntityList.forEach(activityEntity->{
	    	activityDTOList.add(prepareActivityDTO(activityEntity));
	    });
	    
	   
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return activityDTOList;
    }

    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ActivityService#populateOneActivityDetails(java.lang.Long)
     * fetching a single activity entity by it's id
     */
    @Override
    public ActivityDTO populateOneActivityDetails(Long userId) {
    	Activity activityEntity = activityDao.findActivityById(userId);
	return prepareActivityDTO(activityEntity);
    }

    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ActivityService#destroyActivity(java.lang.Long)
     * deleting activity table entity by it's id
     */
    @Override
    public DeleteDTO destroyActivity(Long userId) {

	activityDao.deleteActivity(userId);
	
	
    
	DeleteDTO deleteDTO = new DeleteDTO();
	
	
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");
		
		
		return deleteDTO;
		
	
    }

  
}
