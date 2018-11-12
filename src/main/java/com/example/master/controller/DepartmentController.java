package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

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

import com.example.master.component.DepartmentDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.entity.Department;
import com.example.master.services.DepartmentService;
import com.example.master.services.serviceImpl.DepartmentServiceImpl;

@RestController
@RequestMapping("/department/")
public class DepartmentController implements DepartmentService {

    @Autowired
    DepartmentServiceImpl departmentService;
    
    @Autowired
    DepartmentDao departmentDao;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addDepartment", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> persistDepartment(@RequestBody DepartmentDTO departmentDTO) {

    	List<Department> department = 
    			departmentDao.findByDeptNameAndOrgId(departmentDTO.getdepartmentName().toUpperCase(), 
    					departmentDTO.getorgId());
    	
    	if(department.isEmpty()) {
    		System.out.println("inside if condition "+department);
    		
    		departmentService.persistDepartment(departmentDTO);
    		
    		return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CREATED);
    	}else {
    		System.out.println("inside else condition "+department);
    		
    		return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.ALREADY_REPORTED);
    	}
    	
    	
	

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {

    	departmentService.updateDepartment(departmentDTO);
    	
	return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CREATED);

    }
    
    
   

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllDepartment", method = RequestMethod.GET)
    @ResponseBody
    public List<DepartmentDTO> populateDepartmentList() {
    	return departmentService.populateDepartmentList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByDepartmentId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public DepartmentDTO populateOneDepartmentDetails(@PathVariable("userId") Long userId) {
    	return departmentService.populateOneDepartmentDetails(userId);
    }
    
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteDepartment/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyDepartment(@PathVariable("Id") Long Id) {

    	return departmentService.destroyDepartment(Id);
    	
    }

   
    

    
}
