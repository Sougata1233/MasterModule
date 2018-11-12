package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.RoleDetails;

public interface RoleDetailsRepository extends JpaRepository<RoleDetails, Long> {

    List<RoleDetails> findById(Long i);

}
