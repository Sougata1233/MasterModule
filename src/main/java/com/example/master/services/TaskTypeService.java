package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.TaskTypeDTO;
import com.example.master.dto.DeleteDTO;


public interface TaskTypeService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<TaskTypeDTO> persistApproverMaster(TaskTypeDTO tasktype);
      
     public TaskTypeDTO populateOneTaskTypeDetails(Long Id);
     
    
    public List<TaskTypeDTO> populateTaskTypeList();
    
    

    public DeleteDTO destroyTaskType(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<TaskTypeDTO> updateApproverMaster(TaskTypeDTO tasktypeDTO);
    
    
    

}
