package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.EmployeeDTO;
import com.example.master.dto.DeleteDTO;

public interface DepartmentService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<DepartmentDTO> persistDepartment(DepartmentDTO department);

     public DepartmentDTO populateOneDepartmentDetails(Long userId);
    public List<DepartmentDTO> populateDepartmentList();

    

     public DeleteDTO destroyDepartment(Long userId);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    

    ResponseEntity<DepartmentDTO> updateDepartment(DepartmentDTO departmentDTO);

    
    

}
