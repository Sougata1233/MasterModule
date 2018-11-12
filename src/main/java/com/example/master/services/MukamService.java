package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.MukamDTO;
import com.example.master.dto.DeleteDTO;

public interface MukamService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<MukamDTO> persistMukam(MukamDTO mukam);

     public MukamDTO populateOneMukamDetails(Long userId);
    public List<MukamDTO> populateMukamList();

    

    public DeleteDTO destroyMukam(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    public MukamDTO getAllMukamByMukamName(String mukam);

    ResponseEntity<MukamDTO> updateMukam(MukamDTO mukamDTO);

    
    

}
