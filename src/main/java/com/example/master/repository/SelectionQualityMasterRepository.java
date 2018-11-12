package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.SelectionQualityMaster;

public interface SelectionQualityMasterRepository extends JpaRepository<SelectionQualityMaster, Long> {

    List<SelectionQualityMaster> findById(Long i);

}
