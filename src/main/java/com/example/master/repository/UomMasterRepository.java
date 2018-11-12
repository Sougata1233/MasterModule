package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.UomMaster;

public interface UomMasterRepository extends JpaRepository<UomMaster, String> {

    List<UomMaster> findById(String i);
    
    List<UomMaster> findByUomDsc(String uomDsc);

}
