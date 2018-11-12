package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.MachineMasterDTO;

import com.example.master.dto.DeleteDTO;

public interface MachineMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<MachineMasterDTO> persistMachineMaster(MachineMasterDTO machinemaster);
      
     public MachineMasterDTO populateOneMachineMasterDetails(String Id);
     
    
    public List<MachineMasterDTO> populateMachineMasterList();
    
    
/*
    public void destroyCountry(Long userId);

   */

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<MachineMasterDTO> updateMachineMaster(MachineMasterDTO machinemasterDTO);
    
    public DeleteDTO destroyMachineMaster(String Id);
    

}
