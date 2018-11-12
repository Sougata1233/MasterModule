package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ItemMasterDTO;
import com.example.master.dto.ItemMasterEditDTO;


public interface ItemMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<ItemMasterDTO> persistItemMaster(ItemMasterDTO itemmaster);
      
     public ItemMasterDTO populateOneItemMasterDetails(String Id);
     
    
    public List<ItemMasterDTO> populateItemMasterList();
    
    public List<ItemMasterDTO> populateItemByGroupCode();
    
    public List<ItemMasterDTO> getAllItemsByGroupCode(String grpCode);
    public ItemMasterEditDTO getAllItemMasterList(String itemCode);
    
   // public List<ItemGroupMasterDTO> populateItemGroupMasterList();
    
    
/*
    

   */

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<ItemMasterDTO> updateItemMaster(ItemMasterDTO itemmasterDTO);
    public DeleteDTO destroyItemMaster(String Id);
    
    
    

}
