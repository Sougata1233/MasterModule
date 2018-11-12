package com.example.master.services.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.master.component.WarehouseDetailsComponent;
import com.example.master.dto.WarehouseDetailsDTO;
import com.example.master.entity.WarehouseDetails;
import com.example.master.services.WarehouseDetailsService;

/*
 * Service Class For WarehouseDetails Entity
 */
@Service
public class WarehouseDetailsServiceImpl implements WarehouseDetailsService {

	@Autowired
	WarehouseDetailsComponent warehouseDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.master.services.WarehouseDetailsService#getAllWarehouseDetails()
	 * 
	 * Fetching All WarehouseDetails Entity
	 * 
	 */
	@Override
	public List<WarehouseDetailsDTO> getAllWarehouseDetails() {
		List<WarehouseDetailsDTO> warehouseDTOs = new ArrayList<>();
		List<WarehouseDetails> warehouses = new ArrayList<>();
		try {
			warehouses = warehouseDao.getAllWarehouseDetails().stream()
					.sorted(Comparator.comparing(WarehouseDetails::getName)).collect(Collectors.toList());
			warehouses.forEach(wh -> {
				WarehouseDetailsDTO w = new WarehouseDetailsDTO();
				w.setAddress(wh.getAddress());
				w.setId(wh.getId());
				w.setName(wh.getName());
				warehouseDTOs.add(w);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(warehouses.parallelStream().collect(Collectors.toSet()));
		return warehouseDTOs;
	}

}
