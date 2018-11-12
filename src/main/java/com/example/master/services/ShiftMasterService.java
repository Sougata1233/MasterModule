package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.ShiftMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface ShiftMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<ShiftMasterDTO> persistShiftMaster(ShiftMasterDTO shiftmaster);

     public ShiftMasterDTO populateOneShiftMasterDetails(Long Id);
    public List<ShiftMasterDTO> populateShiftMasterList();

    

    public DeleteDTO destroyShiftMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<ShiftMasterDTO> updateShiftMaster(ShiftMasterDTO shiftDTO);

    
    

}
