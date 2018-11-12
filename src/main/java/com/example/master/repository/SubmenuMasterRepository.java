package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.SubmenuMaster;

public interface SubmenuMasterRepository extends JpaRepository<SubmenuMaster, Long> {

    List<SubmenuMaster> findById(Long i);

}
