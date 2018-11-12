package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.LeaveMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface LeaveMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<LeaveMasterDTO> persistLeaveMaster(LeaveMasterDTO leavemaster);

     public LeaveMasterDTO populateOneLeaveMasterDetails(Long userId);
    public List<LeaveMasterDTO> populateLeaveMasterList();

    

    public DeleteDTO destroyLeaveMaster(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<LeaveMasterDTO> updateLeaveMaster(LeaveMasterDTO leavemasterDTO);

    
    

}
