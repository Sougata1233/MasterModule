package com.example.master.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.master.entity.WarehouseDetails;

@Repository
public interface WarehouseDetailsRepository extends JpaRepository<WarehouseDetails, Long>{

}
