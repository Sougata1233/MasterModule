package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.StatusMaster;

public interface StatusMasterRepository extends JpaRepository<StatusMaster, Long> {

    List<StatusMaster> findById(Long i);

}
