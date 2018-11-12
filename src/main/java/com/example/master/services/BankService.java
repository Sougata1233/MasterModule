package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.BankDTO;
import com.example.master.dto.DeleteDTO;

public interface BankService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<BankDTO> persistBank(BankDTO bank);

     public BankDTO populateOneBankDetails(Long Id);
    public List<BankDTO> populateBankList();

    

    public DeleteDTO destroyBank(Long Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<BankDTO> updateBank(BankDTO bankDTO);

    
    

}
