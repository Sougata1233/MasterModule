package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.LocationMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface LocationMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<LocationMasterDTO> persistLocationMaster(LocationMasterDTO locationmaster);

     public LocationMasterDTO populateOneLocationMasterDetails(Long userId);
    public List<LocationMasterDTO> populateLocationMasterList();

    

    public DeleteDTO destroyLocationMaster(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<LocationMasterDTO> updateLeaveMaster(LocationMasterDTO locationmasterDTO);

    
    

}
