package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.ApproverMasterDTO;


public interface ApproverMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<ApproverMasterDTO> persistApproverMaster(ApproverMasterDTO approvermaster);
      
     public ApproverMasterDTO populateOneApproverMasterDetails(Long Id);
     
    
    public List<ApproverMasterDTO> populateApproverMasterList();
    
    

    public void destroyApproverMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<ApproverMasterDTO> updateApproverMaster(ApproverMasterDTO approvermasterDTO);
    
    
    

}
