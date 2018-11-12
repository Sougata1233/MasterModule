package com.example.master.controller;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.component.BrokerDao;
import com.example.master.dto.BrokerDTO;
import com.example.master.dto.BrokerSuppMukamDTO;
import com.example.master.dto.BrokerWithMukamDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Broker;
import com.example.master.services.serviceImpl.BrokerServiceImpl;

@RestController
@RequestMapping("/broker/")
public class BrokerController {
	
	@Autowired
	BrokerServiceImpl brokerService;
	
	@Autowired
	BrokerDao brokerDao;
	
	@GetMapping("getAllBroker")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<BrokerDTO> getAllBroker(){
		return brokerService.populateBrokerList();
	}
	
	@GetMapping("getBrokerByBrokerId/{brokerId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public BrokerDTO getBrokerByBrokerId(@PathVariable("brokerId") long brokerId) {
		return brokerService.populateOneBrokerDetails(brokerId);
	}
	
	@PostMapping("saveBroker")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<BrokerDTO> saveBroker(@RequestBody BrokerDTO brokerDTO){
		List<Broker> broker = brokerDao.getBrokerByBrokerName(brokerDTO.getBrokerName().toUpperCase());
		
		if(broker.isEmpty()) {
			brokerService.persistBroker(brokerDTO);
			return new ResponseEntity<BrokerDTO>(brokerDTO, HttpStatus.CREATED);
		}else {
			System.out.println("Entity Already Exists");
			return new ResponseEntity<BrokerDTO>(brokerDTO, HttpStatus.ALREADY_REPORTED);
		}
		
		
	}
	
	@PostMapping("updateBroker")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<BrokerDTO> updateBroker(@RequestBody BrokerDTO brokerDTO) {
		brokerService.updateBroker(brokerDTO);
		return new ResponseEntity<BrokerDTO>(brokerDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteBroker/{brokerId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public DeleteDTO deleteBroker(@PathVariable("brokerId") long brokerId) {
		
    	return brokerService.deleteBroker(brokerId);
    	
	}
	
	@GetMapping("getBrokerAndMukamByBrokerId/{brokerId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public BrokerWithMukamDTO getBrokerAndMukamByBrokerId(@PathVariable("brokerId") long brokerId){
		return brokerService.getBrokerSupplierMukamByBrokerId(brokerId);
	}
	
	@GetMapping("brokersupplist")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<BrokerSuppMukamDTO> getBrokerAndMukamSupplier(){
		return brokerService.getBrokerMukamSupplier();
	}
	
	@GetMapping("brokersupplistbyid/{id}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public BrokerSuppMukamDTO getBrokerAndMukamSupplierById(@PathVariable("id") String id){
		return brokerService.getBrokerMukamSupplierById(id);
	}

}
