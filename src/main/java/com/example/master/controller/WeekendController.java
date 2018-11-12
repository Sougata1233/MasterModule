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
import com.example.master.dto.LocationMasterDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.dto.WeekendDTO;
import com.example.master.entity.Weekend;
import com.example.master.services.WeekendService;
import com.example.master.services.serviceImpl.WeekendServiceImpl;


@RestController
@RequestMapping("/weekend/")
public class WeekendController implements WeekendService {

    @Autowired
    WeekendServiceImpl weekendService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addWeekend", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<WeekendDTO> persistWeekend(@RequestBody WeekendDTO weekendDTO) {

    	weekendService.persistWeekend(weekendDTO);
    	
	return new ResponseEntity<WeekendDTO>(weekendDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateWeekend", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<WeekendDTO> updateWeekend(@RequestBody WeekendDTO weekendDTO) {

    	weekendService.updateWeekend(weekendDTO);
    	
	return new ResponseEntity<WeekendDTO>(weekendDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllWeekend", method = RequestMethod.GET)
    @ResponseBody
    public List<WeekendDTO> populateWeekendList() {
	
    	return weekendService.populateWeekendList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByWeekendId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public WeekendDTO populateOneWeekendDetails(@PathVariable("userId") Long userId) {
    
    	return weekendService.populateOneWeekendDetails(userId);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteWeekend/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyWeekend(@PathVariable("userId") Long userId) {

    	weekendService.destroyWeekend(userId);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
