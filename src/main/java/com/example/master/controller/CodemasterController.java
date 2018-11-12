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

import com.example.master.dto.CodemasterDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Codemaster;
import com.example.master.services.CodemasterService;
import com.example.master.services.serviceImpl.CodemasterServiceImpl;

@RestController
@RequestMapping("/codemaster/")
public class CodemasterController {

	@Autowired
	CodemasterServiceImpl codemasterService;

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "addCodemaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CodemasterDTO> persistUser(@RequestBody CodemasterDTO codemasterDTO) {

		codemasterService.persistUser(codemasterDTO);

		return new ResponseEntity<CodemasterDTO>(codemasterDTO, HttpStatus.CREATED);

	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "updateCodemaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CodemasterDTO> updateCodemaster(@RequestBody CodemasterDTO codemasterDTO) {

		codemasterService.updateCodemaster(codemasterDTO);

		return new ResponseEntity<CodemasterDTO>(codemasterDTO, HttpStatus.CREATED);

	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "getAllCodemaster", method = RequestMethod.GET)
	@ResponseBody
	public List<CodemasterDTO> populateCodemasterList() {
		return codemasterService.populateCodemasterList();
	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "getCodemasterById/{code}", method = RequestMethod.GET)
	@ResponseBody
	public CodemasterDTO populateOneCodemasterDetails(@PathVariable("code") String code) {
		return codemasterService.populateOneCodemasterDetails(code);
	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "deleteCodemaster/{code}", method = RequestMethod.DELETE)
	@ResponseBody
	public DeleteDTO destroyCodemaster(@PathVariable("code") String code) {

		codemasterService.destroyCodemaster(code);

		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");

		return deleteDTO;

	}
	
	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "getExpTypeCodemaster", method = RequestMethod.GET)
	@ResponseBody
	public List<CodemasterDTO> populateOneCodemasterDetailsByCodeType() {
		return codemasterService.getCodeMasterByCodeType();
	}

}
