package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.OrganizationDTO;
import com.example.master.dto.DeleteDTO;


public interface OrganizationService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<OrganizationDTO> persistUser(OrganizationDTO organization);

     public OrganizationDTO populateOneOrganizationDetails(Long Id);
     
     public List<OrganizationDTO> getAllHeadOrganization();
     
    public List<OrganizationDTO> populateOrganizationList();

    

    public DeleteDTO destroyOrganization(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<OrganizationDTO> updateOrganization(OrganizationDTO organizationDTO);

    
    

}
