package com.example.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.LocationMaster;

public interface LocationMasterRepository extends JpaRepository<LocationMaster, Long> {

    LocationMaster findById(Long i);
    
}
