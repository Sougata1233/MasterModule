package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.master.entity.ItemGroupMaster;

public interface ItemGroupMasterRepository extends JpaRepository<ItemGroupMaster, String> {

    ItemGroupMaster findById(String i);
    
    @Query("select i from ItemGroupMaster i where i.id != '999'")
    List<ItemGroupMaster> findByGroupIdFilter();
}
