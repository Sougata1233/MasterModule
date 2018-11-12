package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.StateDTO;
import com.example.master.dto.DeleteDTO;



public interface StateService {

     public ResponseEntity<StateDTO> persistState(StateDTO state);
     public StateDTO populateOneStateDetails(long Id);
     public List<StateDTO> populateStateList();
     public DeleteDTO destroyState(long stateId);
     ResponseEntity<StateDTO> updateState(StateDTO stateDTO);
     List<StateDTO> getAllStateByCountry(long countryId);

}
