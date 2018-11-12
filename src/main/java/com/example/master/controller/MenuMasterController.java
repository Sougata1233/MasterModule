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
import com.example.master.dto.MenuMasterDTO;
import com.example.master.dto.SubmenuMasterDTO;
import com.example.master.entity.MenuMaster;
import com.example.master.entity.SubmenuMaster;
import com.example.master.services.MenuMasterService;
import com.example.master.services.serviceImpl.MenuMasterServiceImpl;



@RestController
@RequestMapping("/menumaster/")
public class MenuMasterController implements MenuMasterService {

    @Autowired
    MenuMasterServiceImpl menumasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addMenuMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MenuMasterDTO> persistMenuMaster(@RequestBody MenuMasterDTO menumasterDTO) {

    	menumasterService.persistMenuMaster(menumasterDTO);
    	
	   return new ResponseEntity<MenuMasterDTO>(menumasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateMenuMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MenuMasterDTO> updateMenuMaster(@RequestBody MenuMasterDTO menumasterDTO) {

    	menumasterService.updateMenuMaster(menumasterDTO);
    	
	return new ResponseEntity<MenuMasterDTO>(menumasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllMenuMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuMasterDTO> populateMenuMasterList() {
	
    	return menumasterService.populateMenuMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getMenuMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public MenuMasterDTO populateOneMenuMasterDetails(@PathVariable("Id") Long Id) {
    
    	return menumasterService.populateOneMenuMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteMenuMaster/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyMenuMaster(@PathVariable("userId") Long userId) {

    	menumasterService.destroyMenuMaster(userId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
