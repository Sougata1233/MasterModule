package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.ItemGroupDept;
import com.example.master.repository.ItemGroupDeptRepository;

@Component
public class ItemGroupDeptDao {
	
	@Autowired
	ItemGroupDeptRepository itemgroupdeptRepository;
	
	@Transactional
	public List<ItemGroupDept> getAllMap(){
		return (List<ItemGroupDept>) itemgroupdeptRepository.findAll();
	}
	
	@Transactional
	public ItemGroupDept getMapById(long mappId) {
		return itemgroupdeptRepository.findOne(mappId);
	}
	
	@Transactional
	public ItemGroupDept saveMap(ItemGroupDept itemgroudept) {
		return itemgroupdeptRepository.save(itemgroudept);
	}
	
	@Transactional
	public void updateMap(ItemGroupDept itemgroupdept) {
		ItemGroupDept itemgroupmap = itemgroupdeptRepository.findOne(itemgroupdept.getMapId());
		itemgroupmap.setDeptId(itemgroupdept.getDeptId());
		itemgroupmap.setItemGrp(itemgroupdept.getItemGrp());
		itemgroupmap.setIsMapped(itemgroupdept.getIsMapped());
		
		itemgroupdeptRepository.save(itemgroupmap);
	}
	
	@Transactional
	public void deleteMap(long mappingId) {
		itemgroupdeptRepository.delete(mappingId);
	}
	
	@Transactional
	public List<ItemGroupDept> getMapByDeptId(long deptId) {
		return itemgroupdeptRepository.findByDeptId(deptId);
	}
	
	@Transactional
	public List<ItemGroupDept> getMapByItemGroup(String itemGroup) {
		return itemgroupdeptRepository.findByItemGrp(itemGroup);
	}
	
	@Transactional
	public ItemGroupDept getMapByItemGroupEntity(String itemGroup) {
		return itemgroupdeptRepository.findByItemGrpEntity(itemGroup);
	}
	
	@Transactional
	public ItemGroupDept getMapByItemGroupAndDeptId(String itemGroup, long deptId) {
		return itemgroupdeptRepository.findByItemGrpAndDeptId(itemGroup, deptId);
	}
	
	@Transactional
	public List<ItemGroupDept> getMapByItemGroupAndIsMapped(String itemGroup, String isMapped) {
		return itemgroupdeptRepository.findByItemGrpAndIsMapped(itemGroup, isMapped);
	}
	
	public long getNextVal() {
		return itemgroupdeptRepository.seqVal();
	}
	
	@Transactional
	public ItemGroupDept save(ItemGroupDept itemGroupDept) {
		return itemgroupdeptRepository.save(itemGroupDept);
	}
	
	@Transactional
	public ItemGroupDept update(ItemGroupDept itemGroupDept) {
		ItemGroupDept itemgroupdept = itemgroupdeptRepository.findByItemGrpEntity(itemGroupDept.getItemGrp());
		
		itemgroupdept.setDeptId(itemGroupDept.getDeptId());
		itemgroupdept.setIsMapped(itemGroupDept.getIsMapped());
		itemgroupdept.setItemGrp(itemGroupDept.getItemGrp());
		
		return itemgroupdeptRepository.save(itemgroupdept);
	}

}
