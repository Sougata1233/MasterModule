package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

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

import com.example.master.component.MukamDao;
import com.example.master.component.MukamSupplierMapDao;
import com.example.master.component.SupplierMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.SupplierMasterDTO;
import com.example.master.entity.Mukam;
import com.example.master.entity.MukamSupplier;
import com.example.master.entity.SupplierMaster;
import com.example.master.services.SupplierMasterService;
import com.example.master.services.serviceImpl.SupplierMasterServiceImpl;


@RestController
@RequestMapping("/supplierMaster/")
public class SupplierMasterController {

    @Autowired
    SupplierMasterServiceImpl suppliermasterService;
    
    @Autowired
    SupplierMasterDao supplierDao;

    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addSupplierMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SupplierMasterDTO> persistSupplierMaster(@RequestBody SupplierMasterDTO suppliermasterDTO) {

    	List<SupplierMaster> supplier = supplierDao.findBySuppName(suppliermasterDTO.getsuppName().toUpperCase());
    	
    	if(supplier.isEmpty()) {
    		suppliermasterService.persistSupplierMaster(suppliermasterDTO);
    		return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.CREATED);
    	}else {
    		return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.ALREADY_REPORTED);
    	}
    	

    }

    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateSupplierMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SupplierMasterDTO> updateSupplierMaster(@RequestBody SupplierMasterDTO suppliermasterDTO) {

    	suppliermasterService.updateSupplierMaster(suppliermasterDTO);
    	
	return new ResponseEntity<SupplierMasterDTO>(suppliermasterDTO, HttpStatus.CREATED);

    }

    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllSupplierMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<SupplierMasterDTO> populateSupplierMasterList() throws Exception {
	
    	List<SupplierMasterDTO> fetch = suppliermasterService.populateSupplierMasterList();
    	
    	return fetch;
    	
    }

    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getBySupplierMaster/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public SupplierMasterDTO populateOneSupplierMasterDetails(@PathVariable("Id") String Id) {
    
    	long start = Calendar.getInstance().getTimeInMillis();
    	SupplierMasterDTO fetch = suppliermasterService.populateOneSupplierMasterDetails(Id);
    	long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("full time "+(end-start));
    	
    	return fetch;
    	
    }

    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteSupplierMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroySupplierMaster(@PathVariable("Id") String Id) {

    	return suppliermasterService.destroySupplierMaster(Id);
    	
    }

   
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getOtherTypeSupplierMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<SupplierMasterDTO> getAllOtherTypeSupplierMaster() {
    
    	List<SupplierMasterDTO> fetch = suppliermasterService.getOtherTypeSupplierMaster("O");
    	
    	return fetch;
    	
    }

    
}
