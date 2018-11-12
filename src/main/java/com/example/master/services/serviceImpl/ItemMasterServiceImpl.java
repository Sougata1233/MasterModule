package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.ItemMasterDao;
import com.example.master.component.UomMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ItemMasterDTO;
import com.example.master.dto.ItemMasterEditDTO;
import com.example.master.entity.ItemMaster;
import com.example.master.entity.UomMaster;
import com.example.master.services.ItemMasterService;

@Service
public class ItemMasterServiceImpl implements ItemMasterService {

	@Autowired
	ItemMasterDao itemmasterDao;

	@Autowired
	UomMasterDao uomDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemMasterServiceImpl.class);

	private ItemMasterDTO prepareItemMasterDTO(ItemMaster itemmasterEntity) {
		ItemMasterDTO itemmasterDTO = new ItemMasterDTO();

		itemmasterDTO.setgrpCode(itemmasterEntity.getgrpCode());
		itemmasterDTO.setitemDsc(itemmasterEntity.getitemDsc());
		itemmasterDTO.setuomCode(itemmasterEntity.getuomCode());
		itemmasterDTO.setcentralStock(itemmasterEntity.getcentralStock());
		itemmasterDTO.setdirectIndirectTag(itemmasterEntity.getdirectIndirectTag());
		itemmasterDTO.setactiveFlag(itemmasterEntity.getactiveFlag());
		itemmasterDTO.setmake(itemmasterEntity.getmake());
		
		itemmasterDTO.sethsnCode(itemmasterEntity.gethsnCode());
		itemmasterDTO.setmodBy(itemmasterEntity.getmodBy());
		itemmasterDTO.setmodOn(itemmasterEntity.getmodOn());
		itemmasterDTO.setthreshold(itemmasterEntity.getthreshold());
		itemmasterDTO.setlegacyItemCode(itemmasterEntity.getlegacyItemCode());
		itemmasterDTO.setCentralStockValue(itemmasterEntity.getCentralStockValue());
		itemmasterDTO.setMaxOrderValue(itemmasterEntity.getMaxOrderValue());
		itemmasterDTO.setMax(itemmasterEntity.getMax());

		itemmasterDTO.setId(itemmasterEntity.getId());

		return itemmasterDTO;
	}

	@Override
	public ResponseEntity<ItemMasterDTO> persistItemMaster(ItemMasterDTO itemmasterDTO) {

		ItemMaster itemmasterEntity = new ItemMaster();

		itemmasterEntity.setgrpCode(itemmasterDTO.getgrpCode());
		itemmasterEntity.setitemDsc(itemmasterDTO.getitemDsc().toUpperCase());

		itemmasterEntity.setuomCode(itemmasterDTO.getuomCode());
		itemmasterEntity.setcentralStock(itemmasterDTO.getcentralStock());
		itemmasterEntity.setdirectIndirectTag(itemmasterDTO.getdirectIndirectTag());
		itemmasterEntity.setactiveFlag(itemmasterDTO.getactiveFlag());
		itemmasterEntity.setmake(itemmasterDTO.getmake());
		itemmasterEntity.sethsnCode(itemmasterDTO.gethsnCode());
		itemmasterEntity.setmodBy(itemmasterDTO.getmodBy());
		itemmasterEntity.setmodOn(itemmasterDTO.getmodOn());
		itemmasterEntity.setthreshold(itemmasterDTO.getthreshold());
		// itemmasterEntity.setdeptId(itemmasterDTO.getdeptId());
		itemmasterEntity.setlegacyItemCode(itemmasterDTO.getlegacyItemCode());
		itemmasterEntity.setMax(itemmasterDTO.getMax());
		itemmasterEntity.setMaxOrderValue(itemmasterDTO.getMaxOrderValue());
		long seq = itemmasterDao.seqNextVal();
		itemmasterEntity.setId(Long.toString(seq));
		System.out.println(Long.toString(seq));
		itemmasterDao.addItemMaster(itemmasterEntity);
		return new ResponseEntity<ItemMasterDTO>(itemmasterDTO, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<ItemMasterDTO> updateItemMaster(ItemMasterDTO itemmasterDTO) {

		ItemMaster itemmasterEntity = itemmasterDao.findItemMasterById(itemmasterDTO.getId());

		itemmasterEntity.setgrpCode(itemmasterDTO.getgrpCode());
		itemmasterEntity.setitemDsc(itemmasterDTO.getitemDsc());
		
		itemmasterEntity.setuomCode(itemmasterDTO.getuomCode());
		itemmasterEntity.setcentralStock(itemmasterDTO.getcentralStock());
		itemmasterEntity.setdirectIndirectTag(itemmasterDTO.getdirectIndirectTag());
		itemmasterEntity.setactiveFlag(itemmasterDTO.getactiveFlag());
		itemmasterEntity.setmake(itemmasterDTO.getmake());
		String hsn = itemmasterDTO.gethsnCode();
		if(hsn!=null) {
			if (hsn.matches(".*\\d+.*")) {
				itemmasterEntity.sethsnCode(itemmasterDTO.gethsnCode());
			}
		}
		itemmasterEntity.setmodBy(itemmasterDTO.getmodBy());
		itemmasterEntity.setmodOn(itemmasterDTO.getmodOn());
		itemmasterEntity.setthreshold(itemmasterDTO.getthreshold());
		itemmasterEntity.setlegacyItemCode(itemmasterDTO.getlegacyItemCode());

		itemmasterEntity.setMax(itemmasterDTO.getMax());
		itemmasterEntity.setMaxOrderValue(itemmasterDTO.getMaxOrderValue());

		System.out.println("ItemMaster Entity to send to dao is " + itemmasterEntity);
		itemmasterDao.save(itemmasterEntity);
		return new ResponseEntity<ItemMasterDTO>(itemmasterDTO, HttpStatus.CREATED);

	}

	@Override
	public List<ItemMasterDTO> populateItemMasterList() {
		List<ItemMasterDTO> itemmasterDTOList = new ArrayList<ItemMasterDTO>();
		long start = Calendar.getInstance().getTimeInMillis();
		try {
			List<ItemMaster> itemmasterEntityList = itemmasterDao.findAll().stream()
					.sorted(Comparator.comparing(ItemMaster::getitemDsc)).collect(Collectors.toList());
			long forstart = Calendar.getInstance().getTimeInMillis();
			int size = itemmasterEntityList.size();
			for (int i = 0; i < size; i++) {
				itemmasterDTOList.add(prepareItemMasterDTO(itemmasterEntityList.get(i)));
			}
			/*
			 * itemmasterEntityList.forEach(itemmasterEntity->{
			 * itemmasterDTOList.add(prepareItemMasterDTO(itemmasterEntity)); });
			 */
			long forend = Calendar.getInstance().getTimeInMillis();
			System.out.println("for time " + (forend - forstart));
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("All time " + (end - start));
		return itemmasterDTOList;
	}

	@Override
	public ItemMasterDTO populateOneItemMasterDetails(String userId) {
		ItemMaster itemmasterEntity = itemmasterDao.findItemMasterById(userId);

		return prepareItemMasterDTO(itemmasterEntity);
	}

	/*
	 * private ItemMasterDTO prepareItemMasterDTO(Object itemmasterEntity) {
	 * ItemMasterDTO itemDTO = new ItemMasterDTO();
	 * 
	 * itemDTO.setactiveFlag(itemmasterEntity);
	 * itemDTO.setcentralStock(centralStock);
	 * itemDTO.setdirectIndirectTag(directIndirectTag);
	 * itemDTO.setCentralStockValue(centralStockValue); itemDTO.setgrpCode(grpCode);
	 * itemDTO.sethsnCode(hsnCode); itemDTO.setId(id); itemDTO.setitemDsc(itemDsc);
	 * itemDTO.setlegacyItemCode(legacyItemCode); itemDTO.setmake(make);
	 * itemDTO.setMax(max); itemDTO.setMaxOrderValue(maxOrderValue);
	 * itemDTO.setmodBy(modBy); itemDTO.setmodOn(modOn);
	 * itemDTO.setthreshold(threshold); itemDTO.setuomCode(uomCode);
	 * 
	 * return itemDTO; }
	 */

	@Override
	public DeleteDTO destroyItemMaster(String Id) {

		itemmasterDao.deleteItemMaster(Id);
		DeleteDTO deleteDTO = new DeleteDTO();
		deleteDTO.setstatus(1);
		deleteDTO.setstatusCode(2000);
		deleteDTO.setmsg("Deleted successfully.");

		return deleteDTO;

	}

	@Override
	public List<ItemMasterDTO> populateItemByGroupCode() {

		List<ItemMasterDTO> itemmasterDTOList = new ArrayList<ItemMasterDTO>();

		try {
			String groupcode = "999";
			List<ItemMaster> items = itemmasterDao.getItemMasterByGroupCode(groupcode).stream()
					.sorted(Comparator.comparing(ItemMaster::getitemDsc)).collect(Collectors.toList());
			items.forEach(item -> {
				itemmasterDTOList.add(prepareItemMasterDTO(item));
				System.out.println(item);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemmasterDTOList;
	}

	@Override
	public List<ItemMasterDTO> getAllItemsByGroupCode(String grpCode) {

		List<ItemMaster> itemmasterList = itemmasterDao.getItemMasterByGroupCode(grpCode).stream()
				.sorted(Comparator.comparing(ItemMaster::getitemDsc)).collect(Collectors.toList());
		List<ItemMasterDTO> itemmasterDTOList = new ArrayList<>();

		itemmasterList.forEach(item -> {
			itemmasterDTOList.add(prepareItemMasterDTO(item));
		});

		return itemmasterDTOList;
	}

	@Override
	public ItemMasterEditDTO getAllItemMasterList(String itemCode) {
		ItemMasterEditDTO itemeditDTO1 = new ItemMasterEditDTO();
		try {
			// ItemMasterEditDTO itemeditDTO1 = new ItemMasterEditDTO();
			ItemMaster items = itemmasterDao.findItemMasterById(itemCode);
			List<UomMaster> uom = uomDao.findAll();
			System.out.println(items);
			itemeditDTO1.setActiveFlag(items.getactiveFlag());
			itemeditDTO1.setCentralStock(items.getcentralStock());
			itemeditDTO1.setCentralStockValue(items.getCentralStockValue());
			itemeditDTO1.setDirectIndirectTag(items.getdirectIndirectTag());
			itemeditDTO1.setGrpCode(items.getgrpCode());
			itemeditDTO1.setHsnCode(items.gethsnCode());
			itemeditDTO1.setId(items.getId());
			itemeditDTO1.setItemDsc(items.getitemDsc());
			itemeditDTO1.setLegacyItemCode(items.getlegacyItemCode());
			itemeditDTO1.setMake(items.getmake());
			itemeditDTO1.setMax(items.getMax());
			itemeditDTO1.setMaxOrderValue(items.getMaxOrderValue());
			itemeditDTO1.setModBy(items.getmodBy());
			itemeditDTO1.setModOn(items.getmodOn());
			itemeditDTO1.setThreshold(items.getthreshold());
			itemeditDTO1.setUomCode(items.getuomCode());
			itemeditDTO1.setUom(uom);
			// itemeditDTO = itemeditDTO1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemeditDTO1;
	}

}
