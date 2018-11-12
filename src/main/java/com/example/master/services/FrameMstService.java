package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.FrameMstDTO;
import com.example.master.dto.DeleteDTO;

public interface FrameMstService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<FrameMstDTO> persistUser(FrameMstDTO framemst);

     public FrameMstDTO populateOneFrameMstDetails(Long Id);
    public List<FrameMstDTO> populateFrameMstList();

    

    public DeleteDTO destroyFrameMst(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<FrameMstDTO> updateFrameMst(FrameMstDTO activityDTO);

    
    

}
