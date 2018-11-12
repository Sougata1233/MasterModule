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
import com.example.master.dto.ScmIndentTypeMasterDTO;
import com.example.master.entity.ScmIndentTypeMaster;
import com.example.master.services.ScmIndentTypeMasterService;
import com.example.master.services.serviceImpl.ScmIndentTypeMasterServiceImpl;


@RestController
@RequestMapping("/scmIndentTypeMaster/")
public class ScmIndentTypeMasterController implements ScmIndentTypeMasterService {

    @Autowired
    ScmIndentTypeMasterServiceImpl scmindenttypmasterService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addScmIndentTypeMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ScmIndentTypeMasterDTO> persistUser
    											(@RequestBody ScmIndentTypeMasterDTO scmindenttypmasterDTO) {

    	scmindenttypmasterService.persistUser(scmindenttypmasterDTO);
    	
	return new ResponseEntity<ScmIndentTypeMasterDTO>(scmindenttypmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateScmIndentTypeMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ScmIndentTypeMasterDTO> updateScmIndentTypeMaster
    													(@RequestBody ScmIndentTypeMasterDTO scmindenttypmasterDTO) {

    	scmindenttypmasterService.updateScmIndentTypeMaster(scmindenttypmasterDTO);
    	
	return new ResponseEntity<ScmIndentTypeMasterDTO>(scmindenttypmasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllScmIndentTypeMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<ScmIndentTypeMasterDTO> populateScmIndentTypeMasterList() {
	
    	return scmindenttypmasterService.populateScmIndentTypeMasterList();
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getScmIndentTypeMasterById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public ScmIndentTypeMasterDTO populateOneScmIndentTypeMasterDetails(@PathVariable("Id") Long Id) {
    
    	return scmindenttypmasterService.populateOneScmIndentTypeMasterDetails(Id);
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteScmIndentTypeMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyScmIndentTypeMaster(@PathVariable("Id") Long Id) {

    	scmindenttypmasterService.destroyScmIndentTypeMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    	
    }

   
    

    
}
