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

import com.example.master.component.ItemGroupMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ItemGroupMasterDTO;
import com.example.master.entity.ItemGroupMaster;
import com.example.master.repository.ItemGroupMasterRepository;
import com.example.master.services.ItemGroupMasterService;
import com.example.master.services.serviceImpl.ItemGroupMasterServiceImpl;



@RestController
@RequestMapping("/itemgroup/")
public class ItemGroupMasterController implements ItemGroupMasterService {

   @Autowired
   ItemGroupMasterServiceImpl itemgroupmasterService;
   
   @Autowired
   ItemGroupMasterRepository itemgroupDao;
 
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "addItemGroup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemGroupMasterDTO> persistItemGroupMaster(@RequestBody ItemGroupMasterDTO itemgroupmasterDTO) {

    		boolean itemgroup = itemgroupDao.exists(itemgroupmasterDTO.getId());
    	
    	System.out.println(itemgroup);
    	if(itemgroup == false) {
    		itemgroupmasterService.persistItemGroupMaster(itemgroupmasterDTO);
    		return new ResponseEntity<ItemGroupMasterDTO>(itemgroupmasterDTO, HttpStatus.CREATED);
    	}else {
    		return new ResponseEntity<ItemGroupMasterDTO>(itemgroupmasterDTO, HttpStatus.ALREADY_REPORTED);

    	}
    	
	

    }

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "updateItemGroup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemGroupMasterDTO> updateItemGroupMaster(@RequestBody ItemGroupMasterDTO itemgroupmasterDTO) {

    	itemgroupmasterService.updateItemGroupMaster(itemgroupmasterDTO);
    	
	return new ResponseEntity<ItemGroupMasterDTO>(itemgroupmasterDTO, HttpStatus.CREATED);

    }
    

    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getAllItemGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemGroupMasterDTO> populateItemGroupMasterList() {
    	return itemgroupmasterService.populateItemGroupMasterList();
    }
    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getByItemGroupId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ItemGroupMasterDTO populateOneItemGroupMasterDetails(@PathVariable("userId") String userId) {
    	return itemgroupmasterService.populateOneItemGroupMasterDetails(userId);
    }

    
    @Override
    @CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "deleteItemGroupId/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DeleteDTO destroyItemGroupMaster(@PathVariable("Id") String Id) {

    	return itemgroupmasterService.destroyItemGroupMaster(Id);
    	
    }

	@Override
	@CrossOrigin(origins = USER_HOST_SERVER)
    @RequestMapping(value = "getFilteredGroup", method = RequestMethod.GET)
    @ResponseBody
	public List<ItemGroupMasterDTO> populateItemGroupMasterFiletered() {
		return itemgroupmasterService.populateItemGroupMasterFiletered();
	}

   
    

    
}
