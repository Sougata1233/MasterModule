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

import com.example.master.dto.ActivityDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.TaskTypeDTO;
import com.example.master.entity.TaskType;
import com.example.master.services.TaskTypeService;
import com.example.master.services.serviceImpl.TaskTypeServiceImpl;


@RestController
@RequestMapping("/tasktype/")
public class TaskTypeController implements TaskTypeService {

    @Autowired
    TaskTypeServiceImpl tasktypeService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addTaskType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TaskTypeDTO> persistApproverMaster(@RequestBody TaskTypeDTO tasktypeDTO) {

    	tasktypeService.persistApproverMaster(tasktypeDTO);
    	
	return new ResponseEntity<TaskTypeDTO>(tasktypeDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateTaskType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TaskTypeDTO> updateApproverMaster(@RequestBody TaskTypeDTO tasktypeDTO) {

    	tasktypeService.updateApproverMaster(tasktypeDTO);
    	
	return new ResponseEntity<TaskTypeDTO>(tasktypeDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllTaskType", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskTypeDTO> populateTaskTypeList() {
	
    	return tasktypeService.populateTaskTypeList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getTaskTypeById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskTypeDTO populateOneTaskTypeDetails(@PathVariable("Id") Long Id) {
    
    	return tasktypeService.populateOneTaskTypeDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteTaskType/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyTaskType(@PathVariable("Id") Long Id) {

    	tasktypeService.destroyTaskType(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
