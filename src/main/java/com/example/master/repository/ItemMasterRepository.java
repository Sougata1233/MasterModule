package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.dto.ItemMasterDTO;
import com.example.master.entity.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, String> {

    ItemMaster findById(String id);

    @Query("select i from ItemMaster i where i.grpCode = :grpCode")
    List<ItemMaster> findByGroupCode(@Param("grpCode") String grpCode);
    
    List<ItemMaster> findByGrpCode(String grpCode);

    @Query(value = "SELECT ITEMMASTER_SEQ.nextval FROM dual", nativeQuery = true)
    Long getNextSeriesId();
    
    @Query(value = "SELECT ITEMMASTER_SEQ FROM dual", nativeQuery = true)
    Long getPresentSeq();
    
    @Query("delete  from ItemMaster i where i.id = :id")
    void deletes(@Param("id") String id);

	ItemMaster save(ItemMasterDTO itemmasterEntity);
	
	ItemMaster findByItemDsc(String itemDesc);
    
}
