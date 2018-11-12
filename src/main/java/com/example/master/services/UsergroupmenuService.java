package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.UsergroupmenuDTO;
import com.example.master.dto.DeleteDTO;


public interface UsergroupmenuService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<UsergroupmenuDTO> persistUsergroupmenu(UsergroupmenuDTO usergroupmenuDTO);

     public UsergroupmenuDTO populateOneUsergroupmenuDetails(Long userId);
    public List<UsergroupmenuDTO> populateUsergroupmenuList();

    

    public DeleteDTO destroyUsergroupmenu(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<UsergroupmenuDTO> updateUsergroupmenu(UsergroupmenuDTO usergroupmenuDTO);

    
    

}
