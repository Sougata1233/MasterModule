package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.JuteQualityPriceMasterDTO;
import com.example.master.dto.DeleteDTO;



public interface JuteQualityPriceMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<JuteQualityPriceMasterDTO> persistJuteQualityPriceMaster(JuteQualityPriceMasterDTO juteqltpricemaster);
      
     public JuteQualityPriceMasterDTO populateOneJuteQualityPriceMasterDetails(Long Id);
     
    
    public List<JuteQualityPriceMasterDTO> populateJuteQualityPriceMasterList();
    
   // public List<ItemGroupMasterDTO> populateItemGroupMasterList();
    
    

    public DeleteDTO destroyJuteQualityPriceMaster(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<JuteQualityPriceMasterDTO> updateJuteQualityPriceMaster(JuteQualityPriceMasterDTO juteqltpricemasterDTO);
    
    
    

}
