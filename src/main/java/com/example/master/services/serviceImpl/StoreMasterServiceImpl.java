package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.StoreMasterComponent;
import com.example.master.dto.StoreMasterDTO;
import com.example.master.entity.StoreMaster;
import com.example.master.services.StoreMasterService;

/*
 * Service Class For StoreMaster Entity
 */
@Service
public class StoreMasterServiceImpl implements StoreMasterService {
	
	@Autowired
	StoreMasterComponent storeDao;

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.StoreMasterService#getAllStoreMaster()
	 * 
	 * Fetching All StoreMaster Entity
	 * 
	 */
	@Override
	public List<StoreMasterDTO> getAllStoreMaster() {
		List<StoreMasterDTO> storeDTOs = new ArrayList<>();
		try {
			List<StoreMaster> stores = storeDao.getAllStoreMaster()
												.stream()
												.sorted(Comparator.comparing(StoreMaster::getStoreName))
												.collect(Collectors.toList());
			stores.forEach(store->{
				storeDTOs.add(prepareStoreDTO(store));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return storeDTOs;
	}

	/*
	 * Preparing DTO For StoreMaster Entity
	 */
	private StoreMasterDTO prepareStoreDTO(StoreMaster store) {
		StoreMasterDTO storeDTO = new StoreMasterDTO();
		
		storeDTO.setModBy(store.getModBy());
		storeDTO.setModOn(store.getModOn());
		storeDTO.setStoreAddress(store.getStoreAddress());
		storeDTO.setStoreId(store.getStoreId());
		storeDTO.setStoreName(store.getStoreName());
		
		return storeDTO;
	}

}
