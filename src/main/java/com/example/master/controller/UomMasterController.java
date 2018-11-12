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

import com.example.master.component.UomMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.UomMasterDTO;
import com.example.master.entity.UomMaster;
import com.example.master.services.UomMasterService;
import com.example.master.services.serviceImpl.UomMasterServiceImpl;


@RestController
@RequestMapping("/uommaster/")
public class UomMasterController implements UomMasterService {

    @Autowired
    UomMasterServiceImpl uommasterService;
    
    @Autowired
    UomMasterDao uomDao;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addUomMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UomMasterDTO> persistUomMaster(@RequestBody UomMasterDTO uommasterDTO) {

    	List<UomMaster> uoms = uomDao.findUomMasterByIdList(uommasterDTO.getId().toUpperCase());
    	System.out.println(uoms);
    	if(uoms.isEmpty()) {
    		System.out.println("inside if");
    		uommasterService.persistUomMaster(uommasterDTO);
    		return new ResponseEntity<UomMasterDTO>(uommasterDTO, HttpStatus.CREATED);
    		
    	}else {
    		System.out.println("inside else");
    		return new ResponseEntity<UomMasterDTO>(uommasterDTO, HttpStatus.ALREADY_REPORTED);
    	}
    	
    
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateUomMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UomMasterDTO> updateUomMaster(@RequestBody UomMasterDTO uommasterDTO) {

    	uommasterService.updateUomMaster(uommasterDTO);
    	
	return new ResponseEntity<UomMasterDTO>(uommasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllUomMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<UomMasterDTO> populateUomMasterList() {
	
    	return uommasterService.populateUomMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getUomMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public UomMasterDTO populateOneUomMasterDetails(@PathVariable("Id") String Id) {
    
    	return uommasterService.populateOneUomMasterDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteUomMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyUomMaster(@PathVariable("Id") String Id) {

    	uommasterService.destroyUomMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
