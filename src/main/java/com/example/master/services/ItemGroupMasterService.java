package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.ItemMasterDTO;
import com.example.master.dto.ItemGroupMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface ItemGroupMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<ItemGroupMasterDTO> persistItemGroupMaster(ItemGroupMasterDTO itemgroupmaster);
      
     public ItemGroupMasterDTO populateOneItemGroupMasterDetails(String Id);
     
    
    public List<ItemGroupMasterDTO> populateItemGroupMasterList();
    
    public List<ItemGroupMasterDTO> populateItemGroupMasterFiletered();
    
   // public List<ItemGroupMasterDTO> populateItemGroupMasterList();
    
    
/*
   

   */

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<ItemGroupMasterDTO> updateItemGroupMaster(ItemGroupMasterDTO itemgroupmasterDTO);
    public DeleteDTO destroyItemGroupMaster(String Id);
    
    
    

}
