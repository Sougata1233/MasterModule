package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.SubmenuMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface SubmenuMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<SubmenuMasterDTO> persistSubmenuMaster(SubmenuMasterDTO submenumaster);

     public SubmenuMasterDTO populateOneSubmenuMasterDetails(Long Id);
    public List<SubmenuMasterDTO> populateSubmenuMasterList();

    

    public DeleteDTO destroySubmenuMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<SubmenuMasterDTO> updateSubmenuMaster(SubmenuMasterDTO statusDTO);

    
    

}
