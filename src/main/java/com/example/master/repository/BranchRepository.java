package com.example.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
