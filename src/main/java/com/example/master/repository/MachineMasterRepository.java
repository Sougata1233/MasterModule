package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.MachineMaster;

public interface MachineMasterRepository extends JpaRepository<MachineMaster, String> {

    List<MachineMaster> findById(String i);

}
