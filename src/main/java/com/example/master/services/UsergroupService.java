package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.UsergroupDTO;
import com.example.master.dto.DeleteDTO;


public interface UsergroupService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<UsergroupDTO> persistUsergroup(UsergroupDTO user);

     public UsergroupDTO populateOneUsergroupDetails(Long userId);
    public List<UsergroupDTO> populateUsergroupList();

    

    public DeleteDTO destroyUsergroup(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<UsergroupDTO> updateUsergroup(UsergroupDTO usergroupDTO);

    
    

}
