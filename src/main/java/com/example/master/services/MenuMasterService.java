package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.MenuMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface MenuMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<MenuMasterDTO> persistMenuMaster(MenuMasterDTO menumaster);

     public MenuMasterDTO populateOneMenuMasterDetails(Long Id);
    public List<MenuMasterDTO> populateMenuMasterList();

    

    public DeleteDTO destroyMenuMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<MenuMasterDTO> updateMenuMaster(MenuMasterDTO menumasterDTO);

    
    

}
