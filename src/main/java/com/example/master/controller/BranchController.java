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

import com.example.master.dto.BankDTO;
import com.example.master.dto.BranchDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Branch;
import com.example.master.services.BranchService;
import com.example.master.services.serviceImpl.BranchServiceImpl;


@RestController
@RequestMapping("/branch/")
public class BranchController implements BranchService {

    @Autowired
    BranchServiceImpl branchService;


    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addBranch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BranchDTO> persistBranch(@RequestBody BranchDTO branchDTO) {

    	branchService.persistBranch(branchDTO);
	return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateBranch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BranchDTO> updateBranch(@RequestBody BranchDTO branchDTO) {
    	branchService.updateBranch(branchDTO);
	return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllBranch", method = RequestMethod.GET)
    @ResponseBody
    public List<BranchDTO> populateBranchList() {
	return branchService.populateBranchList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getBranchById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public BranchDTO populateOneBranchDetails(@PathVariable("Id") Long Id) {
    	
	return branchService.populateOneBranchDetails(Id);
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteBranch/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyBranch(@PathVariable("Id") Long Id) {

	branchService.destroyBranch(Id);
	
	DeleteDTO deleteDTO = new DeleteDTO();
	deleteDTO.setstatus(1);
	deleteDTO.setstatusCode(2000);
	deleteDTO.setmsg("Deleted successfully.");
	
	
	return deleteDTO;
    }

   
    

    
}
