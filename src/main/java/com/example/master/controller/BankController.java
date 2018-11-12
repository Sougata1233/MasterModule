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
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Bank;
import com.example.master.services.BankService;
import com.example.master.services.serviceImpl.BankServiceImpl;



@RestController
@RequestMapping("/bank/")
public class BankController implements BankService {

    @Autowired
    BankServiceImpl bankService;

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addBank", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BankDTO> persistBank(@RequestBody BankDTO bankDTO) {
    	bankService.persistBank(bankDTO);
	return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateBank", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BankDTO> updateBank(@RequestBody BankDTO bankDTO) {
    	bankService.updateBank(bankDTO);
	return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.CREATED);

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllBank", method = RequestMethod.GET)
    @ResponseBody
    public List<BankDTO> populateBankList() {
	
	return bankService.populateBankList();
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getBankById/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public BankDTO populateOneBankDetails(@PathVariable("Id") Long Id) {
    	return bankService.populateOneBankDetails(Id);
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteBank/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyBank(@PathVariable("Id") Long Id) {

	bankService.destroyBank(Id);
	
	DeleteDTO deleteDTO = new DeleteDTO();
	deleteDTO.setstatus(1);
	deleteDTO.setstatusCode(2000);
	deleteDTO.setmsg("Deleted successfully.");
	
	
	return deleteDTO;
	
    }

   
    

    
}
