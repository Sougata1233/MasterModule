package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.ScmIndentTypeMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface ScmIndentTypeMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<ScmIndentTypeMasterDTO> persistUser(ScmIndentTypeMasterDTO scmindenttypmaster);

     public ScmIndentTypeMasterDTO populateOneScmIndentTypeMasterDetails(Long Id);
    public List<ScmIndentTypeMasterDTO> populateScmIndentTypeMasterList();

    

    public DeleteDTO destroyScmIndentTypeMaster(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<ScmIndentTypeMasterDTO> updateScmIndentTypeMaster(ScmIndentTypeMasterDTO scmindenttypmasterDTO);

    
    

}
