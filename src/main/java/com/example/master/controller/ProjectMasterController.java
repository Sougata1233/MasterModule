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
import com.example.master.dto.ProjectMasterDTO;
import com.example.master.entity.ProjectMaster;
import com.example.master.services.ProjectMasterService;
import com.example.master.services.serviceImpl.ProjectMasterServiceImpl;


@RestController
@RequestMapping("/projectmaster/")
public class ProjectMasterController implements ProjectMasterService {

    @Autowired
    ProjectMasterServiceImpl projectmasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addProjectMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ProjectMasterDTO> persistProjectMaster(@RequestBody ProjectMasterDTO projectmasterDTO) {

    	projectmasterService.persistProjectMaster(projectmasterDTO);
    	
	return new ResponseEntity<ProjectMasterDTO>(projectmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateProjectMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ProjectMasterDTO> updateProjectMaster(@RequestBody ProjectMasterDTO projectmasterDTO) {

    	projectmasterService.updateProjectMaster(projectmasterDTO);
    	
	return new ResponseEntity<ProjectMasterDTO>(projectmasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllProjectMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectMasterDTO> populateProjectMasterList() {
	
    	return projectmasterService.populateProjectMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getProjectMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectMasterDTO populateOneProjectMasterDetails(@PathVariable("Id") Long Id) {
    
    	return projectmasterService.populateOneProjectMasterDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteProjectMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyProjectMaster(@PathVariable("Id") Long Id) {

    	projectmasterService.destroyProjectMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
