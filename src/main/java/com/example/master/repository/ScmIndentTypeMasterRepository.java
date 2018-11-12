package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.ScmIndentTypeMaster;

public interface ScmIndentTypeMasterRepository extends JpaRepository<ScmIndentTypeMaster, Long> {

    List<ScmIndentTypeMaster> findById(Long i);

}
