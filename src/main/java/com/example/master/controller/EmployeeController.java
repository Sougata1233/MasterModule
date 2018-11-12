package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.EmployeeDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.entity.Employee;
import com.example.master.services.EmployeeService;
import com.example.master.services.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee/")
public class EmployeeController implements EmployeeService {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EmployeeDTO> persistEmployee(@RequestBody EmployeeDTO employeeDTO) {

    	employeeService.persistEmployee(employeeDTO);
    	
	return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

    	employeeService.updateEmployee(employeeDTO);
    	
	return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllEmployee", method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeDTO> populateEmployeeList() {
    	return employeeService.populateEmployeeList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByEmployeeId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeDTO populateOneEmployeeDetails(@PathVariable("userId") String userId) {
    	return employeeService.populateOneEmployeeDetails(userId);
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteEmployee/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyEmployee(@PathVariable("userId") String userId) {

    	employeeService.destroyEmployee(userId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    	
    }

   
    

    
}
