package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.RoleDetailsDTO;
import com.example.master.dto.DeleteDTO;

public interface RoleDetailsService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

	
    public ResponseEntity<RoleDetailsDTO> persistRoleDetails(RoleDetailsDTO roledetails);
      
     public RoleDetailsDTO populateOneRoleDetailsDetails(Long Id);
     
    
    public List<RoleDetailsDTO> populateRoleDetailsList();
    
    

    public DeleteDTO destroyRoleDetails(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
  

    ResponseEntity<RoleDetailsDTO> updateRoleDetails(RoleDetailsDTO roledetailsDTO);
    
    
    

}
