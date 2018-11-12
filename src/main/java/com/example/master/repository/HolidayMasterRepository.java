package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.HolidayMaster;

public interface HolidayMasterRepository extends JpaRepository<HolidayMaster, Long> {

    List<HolidayMaster> findById(Long i);
}
