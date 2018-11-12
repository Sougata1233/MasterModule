package com.example.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.master.entity.CostMaster;

@Repository
public interface CostMasterRepository extends JpaRepository<CostMaster, Long> {

}
