package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.EmployeeDTO;
import com.example.master.dto.DeleteDTO;

public interface EmployeeService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<EmployeeDTO> persistEmployee(EmployeeDTO employee);

     public EmployeeDTO populateOneEmployeeDetails(String userId);
    public List<EmployeeDTO> populateEmployeeList();

    

    public DeleteDTO destroyEmployee(String userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO);

    
    

}
