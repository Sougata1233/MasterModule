package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.ShiftMaster;

public interface ShiftMasterRepository extends JpaRepository<ShiftMaster, Long> {

    List<ShiftMaster> findById(Long i);

}
