package com.example.master.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.master.component.ItemGroupMasterDao;
import com.example.master.component.ItemMasterDao;
import com.example.master.component.PriceDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.ItemPriceDTO;
import com.example.master.dto.PriceDTO;
import com.example.master.dto.PriceGroupDTO;
import com.example.master.entity.ItemGroupMaster;
import com.example.master.entity.ItemMaster;
import com.example.master.entity.Price;
import com.example.master.services.PriceService;

/*
 * Service Class For PriceMaster Entity
 */
@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	PriceDao priceDao;
	
	@Autowired
	ItemGroupMasterDao itemgroupDao;
	
	@Autowired
	ItemMasterDao itemmasterDao;

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.PriceService#addPrice(com.example.master.dto.PriceDTO)
	 * 
	 * Save Service For PriceMaster Entity
	 * 
	 * @Param
	 * 
	 * PriceDTO
	 * 
	 */
	@Override
	public ResponseEntity<PriceDTO> addPrice(PriceDTO price) {
		
		Price priceEntity = new Price();
		
		priceEntity.setRecievedDate(price.getRecievedDate());
		priceEntity.setItemCode(price.getItemCode());
		priceEntity.setItemGroupCode(price.getItemGroupCode());
		priceEntity.setModBy(price.getModBy());
		priceEntity.setModOn(Date.valueOf(LocalDate.now()));
		priceEntity.setRate(price.getRate());
		priceEntity.setReceivedQty(price.getReceivedQty());
		
		priceDao.save(priceEntity);
		
		return new ResponseEntity<PriceDTO>(price, HttpStatus.CREATED);
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.PriceService#getPriceById(long)
	 * 
	 * Fetching PriceMaster By id
	 * 
	 * @Param
	 * 
	 * Long Id
	 * 
	 */
	@Override
	public PriceDTO getPriceById(long priceId) {
		PriceDTO priceDto = new PriceDTO();
		try {
			Price price = priceDao.getPriceById(priceId);
			priceDto  = populatePriceDTO(price);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return priceDto;
	}

	/*
	 * Preparing DTO For PriceMaster Entity
	 */
	private PriceDTO populatePriceDTO(Price price) {
		PriceDTO priceDTO = new PriceDTO();
		
		priceDTO.setRecievedDate(price.getRecievedDate());
		ItemPriceDTO itemprice = new ItemPriceDTO();

		ItemMaster item = itemmasterDao.findItemMasterById(price.getItemCode());
		itemprice.setId(item.getId());
		itemprice.setItemDesc(item.getitemDsc());
		
		priceDTO.setItem(itemprice);
		PriceGroupDTO groupprice = new PriceGroupDTO();
		
		ItemGroupMaster group = itemgroupDao.findItemGroupMasterById(price.getItemGroupCode());
		groupprice.setId(group.getId());
		groupprice.setGroupDesc(group.getgrpDsc());
		
		priceDTO.setItemGroup(groupprice);
		priceDTO.setItemCode(price.getItemCode());
		priceDTO.setItemGroupCode(price.getItemGroupCode());
		priceDTO.setModBy(price.getModBy());
		priceDTO.setModOn(price.getModOn());
		priceDTO.setPriceId(price.getPriceId());
		priceDTO.setRate(price.getRate());
		priceDTO.setReceivedQty(price.getReceivedQty());
		
		return priceDTO;
	}

	/*
	 * preparing ItemGroupMaster DTO
	 */
	private PriceGroupDTO populateItemDTO(ItemGroupMaster group) {
		PriceGroupDTO priceitem = new PriceGroupDTO();
		
		priceitem.setId(group.getId());
		priceitem.setGroupDesc(group.getgrpDsc());
		
		return priceitem;
	}

	/*
	 * Preparing ItemMaster DTO
	 */
	private ItemPriceDTO populateItemDTO(ItemMaster item) {
		ItemPriceDTO itemprice = new ItemPriceDTO();
		
		itemprice.setId(item.getId());
		itemprice.setItemDesc(item.getitemDsc());
		
		return itemprice;
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.PriceService#getAllPrices()
	 * 
	 * Fetching All PriceMaster Entity
	 * 
	 */
	@Override
	public List<PriceDTO> getAllPrices() {
		List<PriceDTO> priceList = new ArrayList<>();
		try {
			List<Price> prices = priceDao.getAllPrice()
											.stream()
											.sorted(Comparator.comparing(Price::getPriceId))
											.collect(Collectors.toList());
			prices.forEach(price->{
				priceList.add(populatePriceDTO(price));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return priceList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.PriceService#deletePrice(long)
	 * 
	 * Delete Service For PriceMaster
	 * 
	 * @Param
	 * 
	 * Long priceId
	 * 
	 */
	@Override
	public DeleteDTO deletePrice(long priceId) {
		priceDao.delete(priceId);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.PriceService#updatePrice(com.example.master.dto.PriceDTO)
	 * 
	 * Update Service For PriceMaster Entity
	 * 
	 * @Param
	 * 
	 * PriceDTO
	 * 
	 */
	@Override
	public ResponseEntity<PriceDTO> updatePrice(PriceDTO priceDTO) {
		Price priceEntity = priceDao.getPriceById(priceDTO.getPriceId());
		
		priceEntity.setRecievedDate(priceDTO.getRecievedDate());
		priceEntity.setItemCode(priceDTO.getItemCode());
		priceEntity.setItemGroupCode(priceDTO.getItemGroupCode());
		priceEntity.setModBy(priceDTO.getModBy());
		priceEntity.setModOn(Date.valueOf(LocalDate.now()));
		priceEntity.setRate(priceDTO.getRate());
		priceEntity.setReceivedQty(priceDTO.getReceivedQty());
		
		priceDao.save(priceEntity);
		
		return new ResponseEntity<PriceDTO>(priceDTO, HttpStatus.CREATED);
	}

}
