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
import com.example.master.dto.MachineMasterDTO;
import com.example.master.entity.MachineMaster;
import com.example.master.services.MachineMasterService;
import com.example.master.services.serviceImpl.MachineMasterServiceImpl;



@RestController
@RequestMapping("/machinemaster/")
public class MachineMasterController implements MachineMasterService {

    @Autowired
    MachineMasterServiceImpl machinemasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addMachineMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MachineMasterDTO> persistMachineMaster(@RequestBody MachineMasterDTO machinemasterDTO) {

    	machinemasterService.persistMachineMaster(machinemasterDTO);
    	
	return new ResponseEntity<MachineMasterDTO>(machinemasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateMachineMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MachineMasterDTO> updateMachineMaster(@RequestBody MachineMasterDTO machinemasterDTO) {

    	machinemasterService.updateMachineMaster(machinemasterDTO);
    	
	return new ResponseEntity<MachineMasterDTO>(machinemasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllMachineMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<MachineMasterDTO> populateMachineMasterList() {
	
    	return machinemasterService.populateMachineMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByMachineMasterId/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public MachineMasterDTO populateOneMachineMasterDetails(@PathVariable("Id") String Id) {
    
    	return machinemasterService.populateOneMachineMasterDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteMachineMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyMachineMaster(@PathVariable("Id") String Id) {

    	machinemasterService.destroyMachineMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
