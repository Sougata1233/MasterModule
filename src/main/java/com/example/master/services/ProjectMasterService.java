package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.ProjectMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface ProjectMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<ProjectMasterDTO> persistProjectMaster(ProjectMasterDTO projectmaster);
      
     public ProjectMasterDTO populateOneProjectMasterDetails(Long Id);
     
    
    public List<ProjectMasterDTO> populateProjectMasterList();
    
    

    public DeleteDTO destroyProjectMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<ProjectMasterDTO> updateProjectMaster(ProjectMasterDTO projectmasterDTO);
    
    
    

}
