package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.ProjectMaster;

public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Long> {

    List<ProjectMaster> findById(Long i);

}
