package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.ActivityDTO;

import com.example.master.dto.DeleteDTO;

public interface ActivityService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<ActivityDTO> persistUser(ActivityDTO user);

     public ActivityDTO populateOneActivityDetails(Long userId);
    public List<ActivityDTO> populateActivityList();

    

    public DeleteDTO destroyActivity(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<ActivityDTO> updateActivity(ActivityDTO activityDTO);

    
    

}
