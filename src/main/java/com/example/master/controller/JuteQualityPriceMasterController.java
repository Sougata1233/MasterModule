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
import com.example.master.dto.JuteQualityPriceMasterDTO;
import com.example.master.entity.JuteQualityPriceMaster;
import com.example.master.services.JuteQualityPriceMasterService;
import com.example.master.services.serviceImpl.JuteQualityPriceMasterServiceImpl;




@RestController
@RequestMapping("/juteQualityPrice/")
public class JuteQualityPriceMasterController implements JuteQualityPriceMasterService {

   @Autowired
   JuteQualityPriceMasterServiceImpl juteqltpricemasterService;
  

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addJuteQualityPrice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JuteQualityPriceMasterDTO> persistJuteQualityPriceMaster(
    											@RequestBody JuteQualityPriceMasterDTO juteqltpricemasterDTO) {

    	juteqltpricemasterService.persistJuteQualityPriceMaster(juteqltpricemasterDTO);
    	
	return new ResponseEntity<JuteQualityPriceMasterDTO>(juteqltpricemasterDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateJuteQualityPrice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JuteQualityPriceMasterDTO> updateJuteQualityPriceMaster(
    													@RequestBody JuteQualityPriceMasterDTO juteqltpricemasterDTO) {

    	juteqltpricemasterService.updateJuteQualityPriceMaster(juteqltpricemasterDTO);
    	
	return new ResponseEntity<JuteQualityPriceMasterDTO>(juteqltpricemasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllJuteQualityPrice", method = RequestMethod.GET)
    @ResponseBody
    public List<JuteQualityPriceMasterDTO> populateJuteQualityPriceMasterList() {
	
    	return juteqltpricemasterService.populateJuteQualityPriceMasterList();
    	
    }
    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByJuteQualityPriceId/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public JuteQualityPriceMasterDTO populateOneJuteQualityPriceMasterDetails(@PathVariable("Id") Long Id) {
    
    	return juteqltpricemasterService.populateOneJuteQualityPriceMasterDetails(Id);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteJuteQualityPrice/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyJuteQualityPriceMaster(@PathVariable("userId") Long userId) {

    	juteqltpricemasterService.destroyJuteQualityPriceMaster(userId);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

   
    

    
}
