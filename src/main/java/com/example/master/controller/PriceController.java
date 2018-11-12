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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.DeleteDTO;
import com.example.master.dto.PriceDTO;
import com.example.master.services.serviceImpl.PriceServiceImpl;

@RestController
@RequestMapping("/price/")
public class PriceController {
	
	@Autowired
	PriceServiceImpl priceService;
	
	@PostMapping("savePrice")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<PriceDTO> savePrice(@RequestBody PriceDTO price){
		priceService.addPrice(price);
		
		return new ResponseEntity<PriceDTO>(price, HttpStatus.CREATED);
	}
	
	@GetMapping("getAllPrice")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public List<PriceDTO> getAllPrice(){
		return priceService.getAllPrices();
	}
	
	@GetMapping("getPriceByPriceId/{priceId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public PriceDTO getPriceByPriceId(@PathVariable("priceId") long priceId) {
		return priceService.getPriceById(priceId);
	}
	
	@DeleteMapping("deletePrice/{priceId}")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public DeleteDTO deletePrice(@PathVariable("priceId") long priceId) {
		priceService.deletePrice(priceId);
		
		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");
		
		return deleteDTO;
		
	}
	
	
	@PostMapping("updatePrice")
	@CrossOrigin(origins = USER_HOST_SERVER)
	public ResponseEntity<PriceDTO> updatePrice(@RequestBody PriceDTO priceDto){
		priceService.updatePrice(priceDto);
		return new ResponseEntity<PriceDTO>(priceDto, HttpStatus.CREATED);
	}

}
