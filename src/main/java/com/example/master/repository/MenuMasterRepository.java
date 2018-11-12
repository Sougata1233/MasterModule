package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.MenuMaster;

public interface MenuMasterRepository extends JpaRepository<MenuMaster, Long> {

    List<MenuMaster> findById(Long i);

}
