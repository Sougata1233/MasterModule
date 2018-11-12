package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.WeekendDTO;
import com.example.master.dto.DeleteDTO;


public interface WeekendService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<WeekendDTO> persistWeekend(WeekendDTO user);

     public WeekendDTO populateOneWeekendDetails(Long userId);
    public List<WeekendDTO> populateWeekendList();

    

    public DeleteDTO destroyWeekend(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<WeekendDTO> updateWeekend(WeekendDTO activityDTO);

    
    

}
