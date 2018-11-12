package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.LeaveMaster;

public interface LeaveMasterRepository extends JpaRepository<LeaveMaster, Long> {

    List<LeaveMaster> findById(Long i);

}
