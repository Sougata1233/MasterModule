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

import com.example.master.component.ItemMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ItemGroupMasterDTO;
import com.example.master.dto.ItemMasterDTO;
import com.example.master.dto.ItemMasterEditDTO;
import com.example.master.entity.ItemMaster;
import com.example.master.services.ItemMasterService;
import com.example.master.services.serviceImpl.ItemMasterServiceImpl;



@RestController
@RequestMapping("/itemmaster/")
public class ItemMasterController implements ItemMasterService {

    @Autowired
    ItemMasterServiceImpl itemmasterService;
    
    @Autowired
    ItemMasterDao itemDao;


    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addItemMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemMasterDTO> persistItemMaster(@RequestBody ItemMasterDTO itemmasterDTO) {

    	ItemMaster item = itemDao.getItemMasterByItemDesc(itemmasterDTO.getitemDsc());
    	if(item != null) {
    		return new ResponseEntity<ItemMasterDTO>(itemmasterDTO, HttpStatus.ALREADY_REPORTED);
    	}else {
    		itemmasterService.persistItemMaster(itemmasterDTO);
    		return new ResponseEntity<ItemMasterDTO>(itemmasterDTO, HttpStatus.CREATED);
    	}
    	
    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateItemMaster", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemMasterDTO> updateItemMaster(@RequestBody ItemMasterDTO itemmasterDTO) {

    	itemmasterService.updateItemMaster(itemmasterDTO);
    	
	return new ResponseEntity<ItemMasterDTO>(itemmasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllItemMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemMasterDTO> populateItemMasterList() {
	
    	return itemmasterService.populateItemMasterList();
    	
    }
    
    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByItemMasterId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ItemMasterDTO populateOneItemMasterDetails(@PathVariable("userId") String userId) {
    
    	return itemmasterService.populateOneItemMasterDetails(userId);
    	
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteItemMaster/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyItemMaster(@PathVariable("Id") String Id) {

    	itemmasterService.destroyItemMaster(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	
    	return deleteDTO;
    	
    	
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getItemsOfGroup", method = RequestMethod.GET)
    @ResponseBody
	public List<ItemMasterDTO> populateItemByGroupCode() {
		
		return itemmasterService.populateItemByGroupCode();
		
	}

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getItemsByGroupCode/{grpCode}", method = RequestMethod.GET)
    @ResponseBody
	public List<ItemMasterDTO> getAllItemsByGroupCode(@PathVariable("grpCode") String grpCode) {
		// TODO Auto-generated method stub
		return itemmasterService.getAllItemsByGroupCode(grpCode);
	}

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByItemMasterIdEdit/{itemCode}", method = RequestMethod.GET)
    public ItemMasterEditDTO getAllItemMasterList(@PathVariable("itemCode") String itemCode) {
		return itemmasterService.getAllItemMasterList(itemCode);
	}

	
    
}
