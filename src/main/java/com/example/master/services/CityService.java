package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.master.dto.CityDTO;
import com.example.master.dto.DeleteDTO;

public interface CityService {

    //public ResponseEntity<ActivityDTO> getUser(String username);
    public ResponseEntity<CityDTO> persistCity(CityDTO city);
    public CityDTO populateOneCityDetails(int Id);
    public List<CityDTO> populateCityList();
    public DeleteDTO destroyCity(int userId);
    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);
    public List<CityDTO> getCityByState(long stateId);	

    ResponseEntity<CityDTO> updateCity(CityDTO cityDTO);
    
    
    

}
