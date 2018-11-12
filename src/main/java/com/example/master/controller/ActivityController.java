package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.ActivityDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Activity;
import com.example.master.services.ActivityService;
import com.example.master.services.serviceImpl.ActivityServiceImpl;



@RestController
@CrossOrigin(origins = USER_HOST_SERVER)
@RequestMapping("/activity/")
public class ActivityController implements ActivityService {

    @Autowired
    ActivityServiceImpl activityService;

    @Override
    @PostMapping(value = "addActivity")
    @ResponseBody
    public ResponseEntity<ActivityDTO> persistUser(@RequestBody ActivityDTO activityDTO) {
    	activityService.persistUser(activityDTO);
	return new ResponseEntity<ActivityDTO>(activityDTO, HttpStatus.CREATED);

    }

    @Override
    @PostMapping(value = "updateActivity")
    @ResponseBody
    public ResponseEntity<ActivityDTO> updateActivity(@RequestBody ActivityDTO activityDTO) {
    	activityService.updateActivity(activityDTO);
	return new ResponseEntity<ActivityDTO>(activityDTO, HttpStatus.CREATED);

    }

    @Override
    @GetMapping(value = "getAllActivity")
    @ResponseBody
    public List<ActivityDTO> populateActivityList() {
	
	return activityService.populateActivityList();
    }

    @Override
    @GetMapping(value = "getActivityById/{userId}")
    @ResponseBody
    public ActivityDTO populateOneActivityDetails(@PathVariable("userId") Long userId) {
    	
	return activityService.populateOneActivityDetails(userId);
    }

    @Override
    @DeleteMapping(value = "deleteActivity/{userId}")
    @ResponseBody
    public DeleteDTO destroyActivity(@PathVariable("userId") Long userId) {

	activityService.destroyActivity(userId);
	
	
    
	DeleteDTO deleteDTO = new DeleteDTO();
	
	
	deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");
		
		
		return deleteDTO;
		
	
    }
    
}
