package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.UomMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface UomMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<UomMasterDTO> persistUomMaster(UomMasterDTO uommaster);
      
     public UomMasterDTO populateOneUomMasterDetails(String Id);
     
    
    public List<UomMasterDTO> populateUomMasterList();
    
    

    public DeleteDTO destroyUomMaster(String Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<UomMasterDTO> updateUomMaster(UomMasterDTO uommasterDTO);
    
    
    

}
