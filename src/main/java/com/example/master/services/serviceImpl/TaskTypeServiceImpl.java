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

import com.example.master.component.TaskTypeDao;
import com.example.master.dto.ActivityDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.TaskTypeDTO;
import com.example.master.entity.TaskType;
import com.example.master.services.TaskTypeService;

/*
 * Service Class For TaskType Entity
 */
@Service
public class TaskTypeServiceImpl implements TaskTypeService {

    @Autowired
    TaskTypeDao tasktypeDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(TaskTypeServiceImpl.class);

   /*
    * Preparing DTO For TaskType Entity
    */
    private TaskTypeDTO prepareTaskTypeDTO(TaskType tasktypeEntity) {
    	TaskTypeDTO tasktypeDTO = new TaskTypeDTO();
    	
    	tasktypeDTO.settaskName(tasktypeEntity.gettaskName());
    	tasktypeDTO.setactivityId(tasktypeEntity.getactivityId());
    	tasktypeDTO.setmodby(tasktypeEntity.getmodby());
    	tasktypeDTO.setmodifiedOn(tasktypeEntity.getmodifiedOn());
		tasktypeDTO.setId(tasktypeEntity.getId());
    	try {
    		ActivityDTO actDTO = new ActivityDTO();

    		actDTO.setActivityName(tasktypeEntity.getActivity().getActivityName());
    		actDTO.setId(tasktypeEntity.getActivity().getId());

    		tasktypeDTO.setActivity(actDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting Activity {} {}",  e.getMessage());
    	}
        
	    return tasktypeDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.TaskTypeService#persistApproverMaster(com.example.master.dto.TaskTypeDTO)
     * 
     * Save Service For TaskType Entity
     * 
     * @Param
     * 
     * TaskTypeDTO
     * 
     */
    @Override
    public ResponseEntity<TaskTypeDTO> persistApproverMaster(TaskTypeDTO tasktypeDTO) {
    	TaskType tasktypeEntity = new TaskType();
    	
    	tasktypeEntity.settaskName(tasktypeDTO.gettaskName());
    	tasktypeEntity.setactivityId(tasktypeDTO.getactivityId());
    	tasktypeEntity.setmodby(tasktypeDTO.getmodby());
    	tasktypeEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
    	tasktypeDao.addTaskType(tasktypeEntity);

    	return new ResponseEntity<TaskTypeDTO>(tasktypeDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.TaskTypeService#updateApproverMaster(com.example.master.dto.TaskTypeDTO)
     * 
     * Update Service For TaskType Entity
     * 
     * @Param
     * 
     * TaskTypeDTO
     * 
     */
    @Override
    public ResponseEntity<TaskTypeDTO> updateApproverMaster(TaskTypeDTO tasktypeDTO) {
    	TaskType tasktypeEntity = new TaskType();

    	tasktypeEntity.settaskName(tasktypeDTO.gettaskName());
    	tasktypeEntity.setactivityId(tasktypeDTO.getactivityId());
    	tasktypeEntity.setmodby(tasktypeDTO.getmodby());
    	tasktypeEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	tasktypeEntity.setId(tasktypeDTO.getId());
    	

    	tasktypeDao.updateTaskType(tasktypeEntity);
	
    	return new ResponseEntity<TaskTypeDTO>(tasktypeDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.TaskTypeService#populateTaskTypeList()
     * 
     * Fetching All TaskType Entity
     * 
     */
    @Override
    public List<TaskTypeDTO> populateTaskTypeList() {
		List<TaskTypeDTO> tasktypeDTOList=new ArrayList<TaskTypeDTO>();
		try {
		    List<TaskType> tasktypeEntityList=tasktypeDao.findAll()
		    												.stream()
		    												.sorted(Comparator.comparing(TaskType::gettaskName))
		    												.collect(Collectors.toList());
		    
		    tasktypeEntityList.forEach(tasktypeEntity->{
		    	tasktypeDTOList.add(prepareTaskTypeDTO(tasktypeEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return tasktypeDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.TaskTypeService#populateOneTaskTypeDetails(java.lang.Long)
     * 
     * Fetching TaskType By id
     * 
     * @Param 
     * 
     * Long Id
     * 
     */
    @Override
    public TaskTypeDTO populateOneTaskTypeDetails(Long Id) {
    	TaskType tasktypeEntity = tasktypeDao.findTaskTypeById(Id);
	
    	return prepareTaskTypeDTO(tasktypeEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.TaskTypeService#destroyTaskType(java.lang.Long)
     * 
     * Delete Service For TaskType Entity
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public DeleteDTO destroyTaskType(Long Id) {

    	tasktypeDao.deleteTaskType(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
