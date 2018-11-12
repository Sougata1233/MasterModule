package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.BranchDTO;
import com.example.master.dto.DeleteDTO;

public interface BranchService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<BranchDTO> persistBranch(BranchDTO branch);

     public BranchDTO populateOneBranchDetails(Long Id);
    public List<BranchDTO> populateBranchList();

    

    public DeleteDTO destroyBranch(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<BranchDTO> updateBranch(BranchDTO branchDTO);

    
    

}
