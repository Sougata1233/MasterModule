package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.StatusMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface StatusMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<StatusMasterDTO> persistStatusMaster(StatusMasterDTO statusmaster);

     public StatusMasterDTO populateOneStatusMasterDetails(Long Id);
    public List<StatusMasterDTO> populateStatusMasterList();

    

    public DeleteDTO destroyStatusMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<StatusMasterDTO> updateStatusMaster(StatusMasterDTO statusDTO);

    
    

}
