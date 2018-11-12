package com.example.master.services;

import java.util.List;
import com.example.master.dto.DeleteDTO;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.SelectionQualityMasterDTO;


public interface SelectionQualityMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<SelectionQualityMasterDTO> persistSelectionQualityMaster(SelectionQualityMasterDTO selectionqualitymaster);

     public SelectionQualityMasterDTO populateOneSelectionQualityMasterDetails(Long Id);
    public List<SelectionQualityMasterDTO> populateSelectionQualityMasterList();

    

    public DeleteDTO destroyScmIndentTypeMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<SelectionQualityMasterDTO> updateSelectionQualityMaster(SelectionQualityMasterDTO selectionqualitymasterDTO);

    
    

}
