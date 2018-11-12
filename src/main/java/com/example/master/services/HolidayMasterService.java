package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.HolidayMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface HolidayMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<HolidayMasterDTO> persistHolidayMaster(HolidayMasterDTO holidaymaster);

     public HolidayMasterDTO populateOneHolidayMasterDetails(Long Id);
    public List<HolidayMasterDTO> populateHolidayMasterList();

    

    public DeleteDTO destroyHolidayMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<HolidayMasterDTO> updateHolidayMaster(HolidayMasterDTO holidaymasterDTO);

    
    

}
